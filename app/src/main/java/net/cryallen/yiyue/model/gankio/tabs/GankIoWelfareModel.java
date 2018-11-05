package net.cryallen.yiyue.model.gankio.tabs;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.androidlib.helper.RetrofitCreateHelper;
import net.cryallen.androidlib.helper.RxHelper;
import net.cryallen.yiyue.api.GankioApi;
import net.cryallen.yiyue.bean.gankio.GankIoWelfareListBean;
import net.cryallen.yiyue.contract.gankio.tabs.GankIoWelfareContract;

import io.reactivex.Observable;

/***
 Created by chenran on 2018/9/30.
 ***/
public class GankIoWelfareModel extends BaseModel implements GankIoWelfareContract.IGankIoWelfareModel{

	@NonNull
	public static GankIoWelfareModel newInstance() {
		return new GankIoWelfareModel();
	}

	@Override
	public Observable<Boolean> recordItemIsRead(String key) {
		//不记录
		return null;
	}

	@Override
	public Observable<GankIoWelfareListBean> getWelfareList(int pre_page, int page) {
		return RetrofitCreateHelper.createJsonApi(GankioApi.HOST,GankioApi.class)
				.getGankIoWelfareList(pre_page, page)
				.compose(RxHelper.<GankIoWelfareListBean>rxSchedulerHelper());
	}
}
