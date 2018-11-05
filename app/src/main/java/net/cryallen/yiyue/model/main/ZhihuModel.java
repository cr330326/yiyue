package net.cryallen.yiyue.model.main;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.androidlib.config.DBConfig;
import net.cryallen.androidlib.config.ItemState;
import net.cryallen.androidlib.helper.RetrofitCreateHelper;
import net.cryallen.androidlib.helper.RxHelper;
import net.cryallen.androidlib.utils.AppUtils;
import net.cryallen.androidlib.utils.DBUtils;
import net.cryallen.yiyue.api.ZhihuApi;
import net.cryallen.yiyue.bean.zhihu.ZhihuDailyListBean;
import net.cryallen.yiyue.contract.main.ZhihuContract;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/***
 Created by chenran on 2018/10/3.
 ***/
public class ZhihuModel extends BaseModel implements ZhihuContract.IZhihuModel {

	@NonNull
	public static ZhihuModel newInstance() {
		return new ZhihuModel();
	}

	@Override
	public Observable<ZhihuDailyListBean> getDailyList(String date) {
		return RetrofitCreateHelper.createJsonApi(ZhihuApi.HOST,ZhihuApi.class).getDailyListWithDate
				(date).compose(RxHelper.<ZhihuDailyListBean>rxSchedulerHelper());
	}

	@Override
	public Observable<ZhihuDailyListBean> getDailyList() {
		return RetrofitCreateHelper.createJsonApi(ZhihuApi.HOST,ZhihuApi.class).getLastDailyList()
				.compose(RxHelper.<ZhihuDailyListBean>rxSchedulerHelper());
	}

	@Override
	public Observable<Boolean> recordItemIsRead(final String key) {
		return Observable.create(new ObservableOnSubscribe<Boolean>() {
			@Override
			public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
				emitter.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig
						.TABLE_ZHIHU, key, ItemState.STATE_IS_READ));
				emitter.onComplete();
			}
		}).compose(RxHelper.<Boolean>rxSchedulerHelper());
	}
}
