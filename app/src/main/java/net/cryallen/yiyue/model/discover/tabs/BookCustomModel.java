package net.cryallen.yiyue.model.discover.tabs;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.androidlib.helper.RetrofitCreateHelper;
import net.cryallen.androidlib.manager.RxHelper;
import net.cryallen.yiyue.api.DoubanApi;
import net.cryallen.yiyue.bean.douban.book.BookListBean;
import net.cryallen.yiyue.contract.discover.tabs.BookCustomContract;

import io.reactivex.Observable;

/***
 Created by chenran on 2018/9/19.
 ***/
public class BookCustomModel extends BaseModel implements BookCustomContract.IBookCustomModel{
	@NonNull
	public static BookCustomModel newInstance() {
		return new BookCustomModel();
	}

	@Override
	public Observable<BookListBean> getBookListWithTag(String tag, int start, int count) {
		return RetrofitCreateHelper.createJsonApi(DoubanApi.HOST,DoubanApi.class)
				.getBookListWithTag(tag, start, count)
				.compose(RxHelper.<BookListBean>rxSchedulerHelper());
	}

	@Override
	public Observable<Boolean> recordItemIsRead(String key) {
		return null;
	}
}
