package net.cryallen.yiyue.api;

import net.cryallen.yiyue.bean.weixin.WeixinChoiceListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/***
 * 微信精选API地址
 Created by chenran on 2018/9/15.
 ***/
public interface WeixinApi {
	public static final String HOST = "http://v.juhe.cn";

	@GET("/weixin/query")
	Observable<WeixinChoiceListBean> getWeixinChoiceList(@Query("pno") int page, @Query("ps") int
			ps, @Query("dtype") String dttype, @Query("key") String key);

}
