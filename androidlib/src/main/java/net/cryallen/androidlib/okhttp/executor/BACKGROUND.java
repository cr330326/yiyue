package net.cryallen.androidlib.okhttp.executor;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

/**
 * BACKGROUND
 */
public final class BACKGROUND implements Executor {
    @Override
    public void execute(@NonNull Runnable command) {
        command.run();
    }
}
