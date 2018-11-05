package net.cryallen.yiyue.model.detail;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.androidlib.helper.RetrofitCreateHelper;
import net.cryallen.androidlib.helper.RxHelper;
import net.cryallen.yiyue.api.ZhihuApi;
import net.cryallen.yiyue.bean.zhihu.ZhihuDailyDetailBean;
import net.cryallen.yiyue.contract.detail.ZhihuDetailContract;

import io.reactivex.Observable;

/***
 Created by chenran on 2018/9/30.
 ***/
public class ZhihuDetailModel extends BaseModel implements ZhihuDetailContract.IZhihuDetailModel {
	@NonNull
	public static ZhihuDetailModel newInstance() {
		return new ZhihuDetailModel();
	}

	@Override
	public Observable<ZhihuDailyDetailBean> getDailyDetail(String id) {
		return RetrofitCreateHelper.createJsonApi(ZhihuApi.HOST,ZhihuApi.class).getZhihuDailyDetail
				(id).compose(RxHelper.<ZhihuDailyDetailBean>rxSchedulerHelper());
	}
}
