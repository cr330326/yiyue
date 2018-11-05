package net.cryallen.yiyue.model.main;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.yiyue.contract.main.HomeMainContract;

/***
 Created by chenran on 2018/9/30.
 ***/
public class HomeMainModel extends BaseModel implements HomeMainContract.IHomeMainModel {

	@NonNull
	public static HomeMainModel newInstance() {
		return new HomeMainModel();
	}

	@Override
	public String[] getTabs() {
		return new String[]{"知乎日报", "网易新闻", "微信精选"};
	}
}
