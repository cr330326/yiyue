package net.cryallen.androidlib.okhttp.callback;


import net.cryallen.androidlib.okhttp.network.HttpResponse;
import net.cryallen.androidlib.okhttp.exception.ParserException;

/**
 * GSONResponseHandler
 */
public abstract class GsonICallbackHandler<T> extends JsonICallbackHandler {

    @Override
    final public void onSuccess(JSON data, HttpResponse response) {
        if (data.jsonArray != null) {
            onSuccess(parser(data.jsonArray.toString()));
        }
        else if (data.jsonObject != null) {
            onSuccess(parser(data.jsonObject.toString()));
        }
        else {
            onFailure(response, new ParserException());
        }
    }

    @Override
    public void onFailure(HttpResponse response, Throwable throwable) {

    }

    /** parser Json to T */
    protected abstract T parser(String jsonString);

    public void onSuccess(T t){

    }

}
