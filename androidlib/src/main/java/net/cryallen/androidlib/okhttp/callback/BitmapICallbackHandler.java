package net.cryallen.androidlib.okhttp.callback;

import android.graphics.Bitmap;

import net.cryallen.androidlib.okhttp.network.HttpResponse;
import net.cryallen.androidlib.okhttp.abstarct.AbsICallbackHandler;
import net.cryallen.androidlib.okhttp.interf.IAccept;

/**
 * BitmapICallbackHandler
 */
public abstract class BitmapICallbackHandler extends AbsICallbackHandler<Bitmap> {
    @Override
    public void onSuccess(Bitmap bitmap, HttpResponse response) {
    }

    @Override
    public void onFailure(HttpResponse response, Throwable throwable) {

    }

    @Override
    public String accept() {
        return IAccept.ACCEPT_IMAGE;
    }

}
