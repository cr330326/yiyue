package net.cryallen.yiyue.model.main;

import android.support.annotation.NonNull;

import net.cryallen.yiyue.config.DBConfig;
import net.cryallen.yiyue.config.ItemState;
import net.cryallen.androidlib.helper.RetrofitCreateHelper;
import net.cryallen.androidlib.manager.RxHelper;
import net.cryallen.androidlib.utils.AppUtils;
import net.cryallen.yiyue.utils.DBUtils;
import net.cryallen.yiyue.api.NeteaseApi;
import net.cryallen.yiyue.bean.netease.NeteaseNewsListBean;
import net.cryallen.yiyue.contract.main.NeteaseContract;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/***
 Created by chenran on 2018/9/30.
 ***/
public class NeteaseModel implements NeteaseContract.INeteaseModel{
	@NonNull
	public static NeteaseModel newInstance() {
		return new NeteaseModel();
	}

	@Override
	public Observable<NeteaseNewsListBean> getNewsList(int id) {
		return RetrofitCreateHelper.createJsonApi(NeteaseApi.HOST,NeteaseApi.class)
				.getNewsList(id)
				.compose(RxHelper.<NeteaseNewsListBean>rxSchedulerHelper());
	}

	@Override
	public Observable<Boolean> recordItemIsRead(final String key) {
		return Observable.create(new ObservableOnSubscribe<Boolean>() {
			@Override
			public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
				emitter.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig
						.TABLE_WANGYI, key, ItemState.STATE_IS_READ));
				emitter.onComplete();
			}
		}).compose(RxHelper.<Boolean>rxSchedulerHelper());
	}
}
