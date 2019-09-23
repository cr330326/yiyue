package net.cryallen.androidlib.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import net.cryallen.androidlib.utils.LoggerUtils;

/**
 *
 * Created by chenran3 on 2017/10/24.
 */

public class GlobalApplication extends Application {

	private static final String LOG_TAG = "YIYUE_LOGGER";
	protected static Context context;
	protected static Handler handler;
	protected static int mainThreadId;
	private static GlobalApplication mApp;

	public static synchronized GlobalApplication getInstance() {
		return mApp;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();
		handler = new Handler();
		mainThreadId = android.os.Process.myTid();
		LoggerUtils.init(true);
	}

	/**
	 * 获取上下文对象
	 *
	 * @return context
	 */
	public static Context getContext() {
		return context;
	}

	/**
	 * 获取全局handler
	 *
	 * @return 全局handler
	 */
	public static Handler getHandler() {
		return handler;
	}

	/**
	 * 获取主线程id
	 *
	 * @return 主线程id
	 */
	public static int getMainThreadId() {
		return mainThreadId;
	}
}
