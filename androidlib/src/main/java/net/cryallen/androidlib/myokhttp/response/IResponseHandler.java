package net.cryallen.androidlib.myokhttp.response;

/**
 * 响应接口
 * Created by chenran3 on 2017/10/25.
 */
public interface IResponseHandler {

    void onFailure(int statusCode, String error_msg);

    void onProgress(long currentBytes, long totalBytes);
}
