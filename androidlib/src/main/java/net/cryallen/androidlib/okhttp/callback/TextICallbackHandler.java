package net.cryallen.androidlib.okhttp.callback;

import net.cryallen.androidlib.okhttp.interf.IAccept;
import net.cryallen.androidlib.okhttp.network.HttpResponse;
import net.cryallen.androidlib.okhttp.abstarct.AbsICallbackHandler;

/**
 * TextICallbackHandler
 */
public class TextICallbackHandler extends AbsICallbackHandler<String> {
    @Override
    public void onSuccess(String data, HttpResponse response) {
    }

    @Override
    public void onFailure(HttpResponse response, Throwable throwable) {
    }

    @Override
    public String backgroundParser(HttpResponse response) throws Exception {
        return byteArrayToString(response.raw().body().bytes());
    }

    @Override public String accept() {
        return IAccept.ACCEPT_TEXT;
    }
}
