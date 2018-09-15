package net.cryallen.yiyue.api;

import net.cryallen.yiyue.bean.netease.NeteaseNewsListBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

/***
 * 网易新闻API地址
 Created by chenran on 2018/9/15.
 ***/
public interface NeteaseApi {
	public final String HOST = "http://c.m.163.com";

	@GET("/nc/article/headline/T1348647909107/{id}-20.html")
	Observable<NeteaseNewsListBean> getNewsList(@Path("id") int id);

	@GET("/nc/article/{id}/full.html")
	Observable<ResponseBody> getNewsDetail(@Path("id") String id);
}
