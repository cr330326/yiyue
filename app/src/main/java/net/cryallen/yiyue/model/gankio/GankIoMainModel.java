package net.cryallen.yiyue.model.gankio;

import android.support.annotation.NonNull;

import net.cryallen.yiyue.contract.gankio.GankIoMainContract;

/***
 Created by chenran on 2018/9/30.
 ***/
public class GankIoMainModel implements GankIoMainContract.IGankIoMainModel{

	@NonNull
	public static GankIoMainModel newInstance() {
		return new GankIoMainModel();
	}

	@Override
	public String[] getTabs() {
		return new String[]{"每日推荐", "干货定制", "福利"};
	}
}
