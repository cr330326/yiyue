package net.cryallen.yiyue.model.discover;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.yiyue.contract.discover.DiscoverMainContract;

/***
 Created by chenran on 2018/9/19.
 ***/
public class DiscoverMainModel extends BaseModel implements DiscoverMainContract.IDiscoverMainModel {

	@NonNull
	public static DiscoverMainModel newInstance() {
		return new DiscoverMainModel();
	}

	@Override
	public String[] getTabs() {
		return new String[]{"电影","文学", "文化", "生活"};
	}
}
