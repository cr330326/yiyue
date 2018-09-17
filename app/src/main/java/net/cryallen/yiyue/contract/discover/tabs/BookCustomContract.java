package net.cryallen.yiyue.contract.discover.tabs;

import android.widget.ImageView;

import net.cryallen.yiyue.bean.douban.book.BookItemBean;
import net.cryallen.yiyue.bean.douban.book.BookListBean;
import net.cryallen.yiyue.contract.tabs.BaseTabsContract;

import io.reactivex.Observable;

/***
 Created by chenran on 2018/9/17.
 ***/
public interface BookCustomContract {

	abstract class BookCustomPresenter extends BaseTabsContract.BaseTabsPresenter<IBookCustomModel, IBookCustomView,BookItemBean> {
		/**
		 * item点击事件
		 *
		 * @param position  position
		 * @param item      item
		 * @param imageView imageView
		 */
		public abstract void onItemClick(int position, BookItemBean item, ImageView imageView);
	}

	interface IBookCustomModel extends BaseTabsContract.IBaseTabsModel {
		/**
		 * 根据tag获取图书
		 *
		 * @param tag   搜索关键字
		 * @param start 从多少开始，如从"0"开始
		 * @param count 一次请求的数目 最多100
		 * @return Observable
		 */
		Observable<BookListBean> getBookListWithTag(String tag, int start, int count);
	}

	interface IBookCustomView extends BaseTabsContract.IBaseTabsView {
		/**
		 * 返回定制book tags
		 *
		 * @return 定制book tags
		 */
		String getBookTags();
	}
}
