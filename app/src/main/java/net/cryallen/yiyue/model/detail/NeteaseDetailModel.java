package net.cryallen.yiyue.model.detail;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.androidlib.helper.RetrofitCreateHelper;
import net.cryallen.androidlib.helper.RxHelper;
import net.cryallen.yiyue.api.NeteaseApi;
import net.cryallen.yiyue.contract.detail.NeteaseDetailContract;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/***
 Created by chenran on 2018/9/30.
 ***/
public class NeteaseDetailModel extends BaseModel implements NeteaseDetailContract.INeteaseDetailModel {
	@NonNull
	public static NeteaseDetailModel newInstance() {
		return new NeteaseDetailModel();
	}

	@Override
	public Observable<ResponseBody> getNewsDetail(String id) {
		return RetrofitCreateHelper.createJsonApi(NeteaseApi.HOST,NeteaseApi.class).getNewsDetail(id)
				.compose(RxHelper.<ResponseBody>rxSchedulerHelper());
	}
}
