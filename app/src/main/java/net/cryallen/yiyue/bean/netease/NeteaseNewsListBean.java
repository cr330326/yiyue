package net.cryallen.yiyue.bean.netease;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/***
 Created by chenran on 2018/9/15.
 ***/
public class NeteaseNewsListBean implements Serializable {

	@SerializedName("T1348647909107")
	ArrayList<NeteaseNewsItemBean> newsList;

	public ArrayList<NeteaseNewsItemBean> getNewsList() {
		return newsList;
	}

	public void setNewsList(ArrayList<NeteaseNewsItemBean> newsList) {
		this.newsList = newsList;
	}
}
