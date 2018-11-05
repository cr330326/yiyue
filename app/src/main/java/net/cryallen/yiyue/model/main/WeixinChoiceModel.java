package net.cryallen.yiyue.model.main;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.androidlib.config.DBConfig;
import net.cryallen.androidlib.config.ItemState;
import net.cryallen.androidlib.helper.RetrofitCreateHelper;
import net.cryallen.androidlib.helper.RxHelper;
import net.cryallen.androidlib.utils.AppUtils;
import net.cryallen.androidlib.utils.DBUtils;
import net.cryallen.yiyue.api.WeixinApi;
import net.cryallen.yiyue.bean.weixin.WeixinChoiceListBean;
import net.cryallen.yiyue.contract.main.WeixinContract;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


/***
 Created by chenran on 2018/10/3.
 ***/
public class WeixinChoiceModel extends BaseModel implements WeixinContract.IWeixinModel {

	@NonNull
	public static WeixinChoiceModel newInstance() {
		return new WeixinChoiceModel();
	}

	@Override
	public Observable<Boolean> recordItemIsRead(final String key) {
		return Observable.create(new ObservableOnSubscribe<Boolean>() {
			@Override
			public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
				emitter.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig
						.TABLE_WEIXIN, key, ItemState.STATE_IS_READ));
				emitter.onComplete();
			}
		}).compose(RxHelper.<Boolean>rxSchedulerHelper());
	}

	@Override
	public Observable<WeixinChoiceListBean> getWeixinChoiceList(int page, int pageStrip, String
			dttype, String key) {
		return RetrofitCreateHelper.createJsonApi(WeixinApi.HOST,WeixinApi.class).getWeixinChoiceList
				(page, pageStrip, dttype, key).compose(RxHelper
				.<WeixinChoiceListBean>rxSchedulerHelper());
	}
}
