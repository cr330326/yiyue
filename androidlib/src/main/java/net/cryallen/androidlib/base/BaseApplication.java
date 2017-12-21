package net.cryallen.androidlib.base;

import android.app.Application;
import android.content.Context;

import net.cryallen.androidlib.cache.CacheManager;

/**
 *
 * Created by chenran3 on 2017/10/24.
 */

public class BaseApplication extends Application {

	public static Context mContext;

	public static long delta;

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();
		CacheManager.getInstance().initCacheDir();
	}

	public static synchronized BaseApplication context() {
		return (BaseApplication) mContext;
	}
}
