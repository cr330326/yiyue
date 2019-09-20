package net.cryallen.androidlib.okhttp.body;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import net.cryallen.androidlib.okhttp.utils.MediaTypeUtils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/**
 * JSONBody类
 */
public final class JSONBody extends RequestBody{
    private final static MediaType CONTENT_TYPE = MediaTypeUtils.JSON;
    private final MediaType contentType;
    private final byte[] bytes;

    public JSONBody(String content){
        this(content, null);
    }

    public JSONBody(String content, String charset){
        if (TextUtils.isEmpty(content)){
            throw new NullPointerException("content == null");
        }
        if (TextUtils.isEmpty(charset)){
            charset = "utf-8";
        }
        this.contentType = TextUtils.isEmpty(charset) ? CONTENT_TYPE : MediaType.parse("application/json; charset=" + charset);
        bytes = content.getBytes(contentType.charset());
    }

    @Override
    public MediaType contentType() {
        return contentType;
    }

    @Override
    public long contentLength() throws IOException {
        return bytes.length;
    }

    @Override
    public void writeTo(@NonNull BufferedSink sink) throws IOException {
        sink.write(bytes, 0, bytes.length);
    }

}
