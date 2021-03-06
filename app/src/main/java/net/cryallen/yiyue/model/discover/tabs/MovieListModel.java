package net.cryallen.yiyue.model.discover.tabs;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.androidlib.helper.RetrofitCreateHelper;
import net.cryallen.androidlib.helper.RxHelper;
import net.cryallen.yiyue.api.DoubanApi;
import net.cryallen.yiyue.bean.douban.movie.HotMovieBean;
import net.cryallen.yiyue.contract.discover.tabs.MovieListContract;

import io.reactivex.Observable;

/***
 Created by chenran on 2018/9/19.
 ***/
public class MovieListModel extends BaseModel implements MovieListContract.IMovieListModel {

	@NonNull
	public static MovieListModel newInstance() {
		return new MovieListModel();
	}

	@Override
	public Observable<HotMovieBean> getHotMovieList() {
		return RetrofitCreateHelper.createJsonApi(DoubanApi.HOST,DoubanApi.class)
				.getHotMovie()
				.compose(RxHelper.<HotMovieBean>rxSchedulerHelper());
	}

	@Override
	public Observable<Boolean> recordItemIsRead(String key) {
		return null;
	}
}
