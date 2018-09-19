package net.cryallen.yiyue.model.discover.tabs;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.androidlib.helper.RetrofitCreateHelper;
import net.cryallen.androidlib.helper.RxHelper;
import net.cryallen.yiyue.api.DoubanApi;
import net.cryallen.yiyue.bean.douban.movie.MovieDetailBean;
import net.cryallen.yiyue.bean.douban.movie.child.PersonBean;
import net.cryallen.yiyue.contract.discover.tabs.MovieDetailContract;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/***
 Created by chenran on 2018/9/19.
 ***/
public class MovieDetailModel extends BaseModel implements MovieDetailContract.IMovieDetailModel {
	@NonNull
	public static MovieDetailModel newInstance() {
		return new MovieDetailModel();
	}

	@Override
	public Observable<MovieDetailBean> getMovieDetail(String id) {
		return RetrofitCreateHelper.createJsonApi(DoubanApi.HOST,DoubanApi.class)
				.getMovieDetail(id)
				.compose(RxHelper.<MovieDetailBean>rxSchedulerHelper())
				.map(new Function<MovieDetailBean, MovieDetailBean>() {
					@Override
					public MovieDetailBean apply(MovieDetailBean bean) throws Exception {
						//返回的数据没有person type，根据数组类型指定
						for (PersonBean bean1 : bean.getCasts()) {
							bean1.setType("主演");
						}
						for (PersonBean bean2 : bean.getDirectors()) {
							bean2.setType("导演");
						}
						return bean;
					}
				});
	}
}
