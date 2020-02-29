package net.cryallen.yiyue.model.discover.tabs;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.androidlib.helper.RetrofitCreateHelper;
import net.cryallen.androidlib.manager.RxHelper;
import net.cryallen.yiyue.api.DoubanApi;
import net.cryallen.yiyue.bean.douban.book.BookDetailBean;
import net.cryallen.yiyue.contract.discover.tabs.BookDeatilContract;

import io.reactivex.Observable;

/***
 Created by chenran on 2018/9/19.
 ***/
public class BookDetailModel extends BaseModel implements BookDeatilContract.IBookDetailModel {

	@NonNull
	public static BookDetailModel newInstance() {
		return new BookDetailModel();
	}

	@Override
	public Observable<BookDetailBean> getBookDetail(String id) {
		return RetrofitCreateHelper.createJsonApi(DoubanApi.HOST,DoubanApi.class)
				.getBookDetail(id)
				.compose(RxHelper.<BookDetailBean>rxSchedulerHelper());
	}
}
