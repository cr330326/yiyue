package net.cryallen.androidlib.okhttp.callback;

import net.cryallen.androidlib.okhttp.abstarct.AbsICallbackHandler;
import net.cryallen.androidlib.okhttp.network.HttpResponse;
import net.cryallen.androidlib.okhttp.interf.IAccept;

/**
 * BinaryResponseHandler
 */
public class BinaryICallbackHandler extends AbsICallbackHandler<byte[]> {

    @Override
    public void onSuccess(byte[] data, HttpResponse response) {

    }

    @Override
    public void onFailure(HttpResponse response, Throwable throwable) {

    }

    @Override
    public byte[] backgroundParser(HttpResponse response) throws Exception {
        return response.raw().body().bytes();
    }

    @Override
    public String accept() {
        return IAccept.ACCEPT_DATA;
    }
}
