package net.cryallen.androidlib.okhttp.response;
import net.cryallen.androidlib.okhttp.interf.IResponseHandler;
import net.cryallen.androidlib.utils.AppUtils;
import net.cryallen.androidlib.utils.LogUtils;

import java.io.IOException;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 字符串结果回调
 * Created by chenran3 on 2017/10/25.
 */
public abstract class StringResponseHandler implements IResponseHandler {
    @Override
    public final void onSuccess(final Response response) {
        ResponseBody responseBody = response.body();
        String responseBodyStr = "";

        try {
            responseBodyStr = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
            LogUtils.e("onResponse fail read response body");
            AppUtils.getHandler().post(new Runnable() {
                @Override
                public void run() {
                    onFailure(response.code(), "fail read response body");
                }
            });
            return;
        } finally {
            responseBody.close();
        }

        final String finalResponseBodyStr = responseBodyStr;
        AppUtils.getHandler().post(new Runnable() {
            @Override
            public void run() {
                onSuccess(response.code(), finalResponseBodyStr);
            }
        });

    }

    public abstract void onSuccess(int statusCode, String response);

    @Override
    public void onProgress(long currentBytes, long totalBytes) {

    }
}
