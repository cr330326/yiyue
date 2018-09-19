package net.cryallen.yiyue.model.discover.tabs;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.androidlib.helper.RetrofitCreateHelper;
import net.cryallen.androidlib.helper.RxHelper;
import net.cryallen.yiyue.api.DoubanApi;
import net.cryallen.yiyue.bean.douban.movie.HotMovieBean;
import net.cryallen.yiyue.contract.discover.tabs.TopMovieContract;

import io.reactivex.Observable;

/***
 Created by chenran on 2018/9/19.
 ***/
public class TopMovieModel extends BaseModel implements TopMovieContract.ITopMovieModel {

	@NonNull
	public static TopMovieModel newInstance() {
		return new TopMovieModel();
	}

	@Override
	public Observable<HotMovieBean> getTopMovieList(int start, int count) {
		return RetrofitCreateHelper.createJsonApi(DoubanApi.HOST,DoubanApi.class)
				.getMovieTop250(start, count)
				.compose(RxHelper.<HotMovieBean>rxSchedulerHelper());
	}

	@Override
	public Observable<Boolean> recordItemIsRead(String key) {
		return null;
	}
}
