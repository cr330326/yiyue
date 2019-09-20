package net.cryallen.androidlib.okhttp.builder;

import net.cryallen.androidlib.okhttp.OkHttpManager;
import net.cryallen.androidlib.okhttp.callback.SimpleCallbackHandler;
import net.cryallen.androidlib.okhttp.interf.IResponseHandler;
import net.cryallen.androidlib.utils.LogUtils;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * patch builder
 * Created by chenran3 on 2017/10/25.
 */
public class PatchBuilder extends OkHttpRequestBuilder<PatchBuilder> {

    public PatchBuilder(OkHttpManager okHttpManager) {
        super(okHttpManager);
    }

    @Override
    public void enqueue(final IResponseHandler responseHandler) {
        try {
            if(mUrl == null || mUrl.length() == 0) {
                throw new IllegalArgumentException("url can not be null !");
            }

            Request.Builder builder = new Request.Builder().url(mUrl);
            appendHeaders(builder, mHeaders);

            if (mTag != null) {
                builder.tag(mTag);
            }

            builder.patch(RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), ""));
            Request request = builder.build();

            mOkHttpManager.getOkHttpClient()
                    .newCall(request)
                    .enqueue(new SimpleCallbackHandler(responseHandler));
        } catch (Exception e) {
            LogUtils.e("Patch enqueue error:" + e.getMessage());
            responseHandler.onFailure(0, e.getMessage());
        }
    }
}
