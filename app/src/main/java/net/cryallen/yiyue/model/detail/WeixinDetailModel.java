package net.cryallen.yiyue.model.detail;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.yiyue.contract.detail.WeixinDetailContract;

/***
 Created by chenran on 2018/9/30.
 ***/
public class WeixinDetailModel extends BaseModel implements WeixinDetailContract.IWeixinDetailModel{

	@NonNull
	public static WeixinDetailModel newInstance() {
		return new WeixinDetailModel();
	}
}
