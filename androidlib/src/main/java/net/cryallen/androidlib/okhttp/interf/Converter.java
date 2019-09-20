package net.cryallen.androidlib.okhttp.interf;

/**
 * Description  : Converter
 */
public interface Converter<T, R> {

    R apply(T t) throws Exception;
}
