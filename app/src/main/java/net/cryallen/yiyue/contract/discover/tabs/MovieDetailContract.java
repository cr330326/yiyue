package net.cryallen.yiyue.contract.discover.tabs;

import net.cryallen.androidlib.base.BasePresenter;
import net.cryallen.androidlib.base.IBaseActivity;
import net.cryallen.androidlib.base.IBaseModel;
import net.cryallen.yiyue.bean.douban.movie.MovieDetailBean;
import net.cryallen.yiyue.bean.douban.movie.child.PersonBean;
import net.cryallen.yiyue.bean.douban.movie.child.SubjectsBean;

import io.reactivex.Observable;

/***
 Created by chenran on 2018/9/17.
 ***/
public interface MovieDetailContract {

	abstract class MovieDetailPresenter extends BasePresenter<IMovieDetailModel,
				IMovieDetailView> {
		/**
		 * 加载电影详情
		 *
		 * @param id 电影id
		 */
		public abstract void loadMovieDetail(String id);

		/**
		 * item点击事件
		 *
		 * @param position  position
		 * @param item      item
		 */
		public abstract void onItemClick(int position, PersonBean item);

		/**
		 * header点击事件
		 * @param bean bean
		 */
		public abstract void onHeaderClick(SubjectsBean bean);
	}

	interface IMovieDetailModel extends IBaseModel {
		/**
		 * 获取电影详情
		 *
		 * @param id 电影id
		 * @return 电影详情
		 */
		Observable<MovieDetailBean> getMovieDetail(String id);
	}

	interface IMovieDetailView extends IBaseActivity {
		/**
		 * 显示电影详情
		 *
		 * @param bean 电影详情bean
		 */
		void showMovieDetail(MovieDetailBean bean);

		/**
		 * 显示网络错误
		 */
		void showNetworkError();
	}
}
