package net.cryallen.androidlib.myokhttp.response;

/**
 * 字符串结果回调
 * Created by chenran3 on 2017/10/25.
 */
public abstract class StringResponseHandler implements IResponseHandler {

    public abstract void onSuccess(int statusCode, String response);

    @Override
    public void onProgress(long currentBytes, long totalBytes) {

    }
}
