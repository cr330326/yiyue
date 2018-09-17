package net.cryallen.yiyue.contract.discover.tabs;

import android.widget.ImageView;

import net.cryallen.yiyue.bean.douban.movie.HotMovieBean;
import net.cryallen.yiyue.bean.douban.movie.child.SubjectsBean;
import net.cryallen.yiyue.contract.tabs.BaseTabsContract;

import io.reactivex.Observable;

/***
 Created by chenran on 2018/9/17.
 ***/
public interface TopMovieContract {
	abstract class TopMoivePresenter extends BaseTabsContract.BaseTabsPresenter<ITopMovieModel, ITopMovieView,SubjectsBean> {
		/**
		 * 加载Top电影list
		 */
		public abstract void loadTopMovieList();

		/**
		 * 加载更多Top电影
		 */
		public abstract void loadMoreTopMovie();

		/**
		 * item点击事件
		 *
		 * @param position  position
		 * @param item      item
		 * @param imageView imageView
		 */
		public abstract void onItemClick(int position, SubjectsBean item, ImageView imageView);
	}

	interface ITopMovieModel extends BaseTabsContract.IBaseTabsModel {
		/**
		 * 获取豆瓣电影top250
		 *
		 * @param start 从多少开始，如从"0"开始
		 * @param count 一次请求的数目，如"10"条，最多100
		 */
		Observable<HotMovieBean> getTopMovieList(int start, int count);
	}

	interface ITopMovieView extends BaseTabsContract.IBaseTabsView {

	}


}
