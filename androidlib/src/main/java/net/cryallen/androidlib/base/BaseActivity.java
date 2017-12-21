package net.cryallen.androidlib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import net.cryallen.androidlib.net.RemoteService;

/**
 * 与业务无关的Activity基类
 * @author ChenRan
 * @since 2017-02-04
 * @version 1.0.0
 */
public abstract class BaseActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initVariables();
		initViews(savedInstanceState);
		loadData();
	}

	/** 初始化变量，包括Intent带的数据和Activity内的变量 **/
	protected abstract void initVariables();

	/** 加载layout布局文件，初始化控件 **/
	protected abstract void initViews(Bundle savedInstanceState);

	/** 加载数据 **/
	protected abstract void loadData();

	@Override
	protected void onPause() {
		super.onPause();
		RemoteService.getInstance().cancelAllRequest();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		RemoteService.getInstance().cancelAllRequest();
	}
}