package net.cryallen.androidlib.okhttp.internal.log;

import net.cryallen.androidlib.okhttp.abstarct.AbsSingleton;
import net.cryallen.androidlib.okhttp.internal.interceptor.HttpLoggingInterceptor;
import net.cryallen.androidlib.utils.LoggerUtils;

/**
 * LoggerImpl
 */
public class LoggerImpl implements HttpLoggingInterceptor.Logger{
    private HttpLoggingInterceptor.Level mLevel;

    public static AbsSingleton<LoggerImpl> instance = new AbsSingleton<LoggerImpl>() {
        @Override protected LoggerImpl create() {
            return new LoggerImpl();
        }
    };

    public void setLevel(HttpLoggingInterceptor.Level level){
        mLevel = level;
    }

    @Override public void log(String message) {
        if (mLevel == HttpLoggingInterceptor.Level.NONE){
            return;
        }
        LoggerUtils.d(message);
    }
}
