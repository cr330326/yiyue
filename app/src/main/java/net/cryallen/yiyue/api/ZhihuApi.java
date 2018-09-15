package net.cryallen.yiyue.api;

import net.cryallen.yiyue.bean.zhihu.ZhihuDailyDetailBean;
import net.cryallen.yiyue.bean.zhihu.ZhihuDailyListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/***
 * 知乎日报API
 Created by chenran on 2018/9/15.
 ***/
public interface ZhihuApi {

	public final String HOST = "http://news-at.zhihu.com";

	@GET("/api/4/news/latest")
	Observable<ZhihuDailyListBean> getLastDailyList();

	@GET("/api/4/news/before/{date}")
	Observable<ZhihuDailyListBean> getDailyListWithDate(@Path("date") String date);

	@GET("/api/4/news/{id}")
	Observable<ZhihuDailyDetailBean> getZhihuDailyDetail(@Path("id") String id);
}
