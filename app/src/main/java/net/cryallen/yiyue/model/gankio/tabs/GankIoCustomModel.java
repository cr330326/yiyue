package net.cryallen.yiyue.model.gankio.tabs;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.androidlib.config.DBConfig;
import net.cryallen.androidlib.config.ItemState;
import net.cryallen.androidlib.helper.RetrofitCreateHelper;
import net.cryallen.androidlib.helper.RxHelper;
import net.cryallen.androidlib.utils.AppUtils;
import net.cryallen.androidlib.utils.DBUtils;
import net.cryallen.yiyue.api.GankioApi;
import net.cryallen.yiyue.bean.gankio.GankIoCustomItemBean;
import net.cryallen.yiyue.bean.gankio.GankIoCustomListBean;
import net.cryallen.yiyue.contract.gankio.tabs.GankIoCustomContract;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

/***
 Created by chenran on 2018/9/30.
 ***/
public class GankIoCustomModel extends BaseModel implements GankIoCustomContract.IGankIoCustomModel{

	@NonNull
	public static GankIoCustomModel newInstance() {
		return new GankIoCustomModel();
	}

	@Override
	public Observable<GankIoCustomListBean> getCustomGankIoList(String type, int prePage, int
			page) {
		return RetrofitCreateHelper.createJsonApi(GankioApi.HOST,GankioApi.class)
				.getGankIoCustomList(type, prePage, page)
				.map(new Function<GankIoCustomListBean, GankIoCustomListBean>() {
					@Override
					public GankIoCustomListBean apply(GankIoCustomListBean gankIoCustomListBean)
							throws Exception {
						for (GankIoCustomItemBean bean : gankIoCustomListBean.getResults()) {
							if (bean.getType().equals("福利")) {
								bean.itemType = GankIoCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_IMAGE;
							} else if (bean.getImages() != null) {
								if (bean.getImages().size() > 0 && !TextUtils.isEmpty(bean.getImages().get(0)))
									bean.itemType = GankIoCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_NORMAL;
							} else {
								bean.itemType = GankIoCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_NO_IMAGE;
							}
						}
						return gankIoCustomListBean;
					}
				})
				.compose(RxHelper.<GankIoCustomListBean>rxSchedulerHelper());
	}

	@Override
	public Observable<Boolean> recordItemIsRead(final String key) {
		return Observable.create(new ObservableOnSubscribe<Boolean>() {
			@Override
			public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
				emitter.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig
						.TABLE_GANKIO_CUSTOM, key, ItemState.STATE_IS_READ));
				emitter.onComplete();
			}
		}).compose(RxHelper.<Boolean>rxSchedulerHelper());
	}
}
