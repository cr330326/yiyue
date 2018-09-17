package net.cryallen.yiyue.contract.discover.tabs;

import android.widget.ImageView;
import net.cryallen.yiyue.bean.douban.movie.HotMovieBean;
import net.cryallen.yiyue.bean.douban.movie.child.SubjectsBean;
import net.cryallen.yiyue.contract.tabs.BaseTabsContract;

import io.reactivex.Observable;

/***
 Created by chenran on 2018/9/17.
 ***/
public interface MovieListContract {

	abstract class MovieListPresenter extends BaseTabsContract.BaseTabsPresenter<IMovieListModel, IMovieListView,SubjectsBean> {
		/**
		 * 加载最新的最热电影
		 */
		public abstract void loadHotMovieList();

		/**
		 * item点击事件
		 *
		 * @param position  position
		 * @param item      item
		 * @param imageView imageView
		 */
		public abstract void onItemClick(int position, SubjectsBean item, ImageView imageView);

		/**
		 * Header被点击
		 */
		public abstract void onHeaderClick();
	}

	interface IMovieListModel extends BaseTabsContract.IBaseTabsModel {
		/**
		 * 获取最热电影
		 *
		 * @return 最热电影
		 */
		Observable<HotMovieBean> getHotMovieList();
	}

	interface IMovieListView extends BaseTabsContract.IBaseTabsView {

	}
}
