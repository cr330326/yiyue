package net.cryallen.androidlib.okhttp.builder;

import net.cryallen.androidlib.okhttp.OkHttpManager;
import net.cryallen.androidlib.okhttp.callback.SimpleCallbackHandler;
import net.cryallen.androidlib.okhttp.interf.IResponseHandler;
import net.cryallen.androidlib.utils.LogUtils;

import java.util.Map;

import okhttp3.Request;

/**
 * Get Builder
 * Created by chenran3 on 2017/10/25.
 */
public class GetBuilder extends OkHttpRequestBuilderHasParam<GetBuilder> {

    public GetBuilder(OkHttpManager okHttpManager) {
        super(okHttpManager);
    }

    @Override
    public void enqueue(final IResponseHandler responseHandler) {
        try {
            if(mUrl == null || mUrl.length() == 0) {
                throw new IllegalArgumentException("url can not be null !");
            }

            if (mParams != null && mParams.size() > 0) {
                mUrl = appendParams(mUrl, mParams);
            }

            Request.Builder builder = new Request.Builder().url(mUrl).get();
            appendHeaders(builder, mHeaders);

            if (mTag != null) {
                builder.tag(mTag);
            }

            Request request = builder.build();

            mOkHttpManager.getOkHttpClient().
                    newCall(request).
                    enqueue(new SimpleCallbackHandler(responseHandler));
        } catch (Exception e) {
            LogUtils.e("Get enqueue error:" + e.getMessage());
            responseHandler.onFailure(0, e.getMessage());
        }
    }

    //append params to url
    private String appendParams(String url, Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(url + "?");
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                sb.append(key).append("=").append(params.get(key)).append("&");
            }
        }

        sb = sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
