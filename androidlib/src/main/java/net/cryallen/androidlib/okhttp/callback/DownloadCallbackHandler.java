package net.cryallen.androidlib.okhttp.callback;

import net.cryallen.androidlib.okhttp.response.DownloadResponseHandler;
import net.cryallen.androidlib.utils.AppUtils;
import net.cryallen.androidlib.utils.LogUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 *  自定义的下载回调类
 *  Created by chenran3 on 2017/10/25.
 */
public class DownloadCallbackHandler implements Callback {
    private DownloadResponseHandler mDownloadResponseHandler;
    private String mFilePath;
    private Long mCompleteBytes;

    public DownloadCallbackHandler(DownloadResponseHandler downloadResponseHandler, String filePath, Long completeBytes) {
        mDownloadResponseHandler = downloadResponseHandler;
        mFilePath = filePath;
        mCompleteBytes = completeBytes;
    }

    @Override
    public void onFailure(Call call, final IOException e) {
        LogUtils.e("onFailure", e);
        AppUtils.getHandler().post(new Runnable() {
            @Override
            public void run() {
                if(mDownloadResponseHandler != null) {
                    mDownloadResponseHandler.onFailure(e.toString());
                }
            }
        });
    }

    @Override
    public void onResponse(Call call, final Response response) throws IOException {
        ResponseBody body = response.body();
        try {
            if (response.isSuccessful()) {
                //开始
                AppUtils.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        if(mDownloadResponseHandler != null) {
                            mDownloadResponseHandler.onStart(response.body().contentLength());
                        }
                    }
                });

                try {
                    if(response.header("Content-Range") == null || response.header("Content-Range").length() == 0){
                        //返回的没有Content-Range 不支持断点下载 需要重新下载
                        mCompleteBytes = 0L;
                    }

                    saveFile(response, mFilePath, mCompleteBytes);

                    final File file = new File(mFilePath);
                    AppUtils.getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            if(mDownloadResponseHandler != null) {
                                mDownloadResponseHandler.onFinish(file);
                            }
                        }
                    });
                } catch (final Exception e) {
                    if(call.isCanceled()) {     //判断是主动取消还是别动出错
                        AppUtils.getHandler().post(new Runnable() {
                            @Override
                            public void run() {
                                if(mDownloadResponseHandler != null) {
                                    mDownloadResponseHandler.onCancel();
                                }
                            }
                        });
                    } else {
                        LogUtils.e("onResponse saveFile fail", e);
                        AppUtils.getHandler().post(new Runnable() {
                            @Override
                            public void run() {
                                if(mDownloadResponseHandler != null) {
                                    mDownloadResponseHandler.onFailure("onResponse saveFile fail." + e.toString());
                                }
                            }
                        });
                    }
                }
            } else {
                LogUtils.e("onResponse fail status=" + response.code());
                AppUtils.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        if(mDownloadResponseHandler != null) {
                            mDownloadResponseHandler.onFailure("fail status=" + response.code());
                        }
                    }
                });
            }
        } finally {
            if(body != null) {
                body.close();
            }
        }
    }

    //保存文件
    private void saveFile(Response response, String filePath, Long completeBytes) throws Exception {
        InputStream is = null;
        byte[] buf = new byte[4 * 1024];           //每次读取4kb
        int len;
        RandomAccessFile file = null;

        try {
            is = response.body().byteStream();
            file = new RandomAccessFile(filePath, "rwd");
            if(completeBytes > 0L) {
                file.seek(completeBytes);
            }

            long complete_len = 0;
            final long total_len = response.body().contentLength();
            while ((len = is.read(buf)) != -1) {
                file.write(buf, 0, len);
                complete_len += len;

                //已经下载完成写入文件的进度
                final long final_complete_len = complete_len;
                AppUtils.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        if(mDownloadResponseHandler != null) {
                            mDownloadResponseHandler.onProgress(final_complete_len, total_len);
                        }
                    }
                });
            }
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
            }
            try {
                if (file != null) file.close();
            } catch (IOException e) {
            }
        }
    }
}
