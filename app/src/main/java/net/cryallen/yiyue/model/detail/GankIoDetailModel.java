package net.cryallen.yiyue.model.detail;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.yiyue.contract.detail.GankIoDetailContract;

/***
 Created by chenran on 2018/9/30.
 ***/
public class GankIoDetailModel extends BaseModel implements GankIoDetailContract.IGankIoDetailModel {
	@NonNull
	public static GankIoDetailModel newInstance() {
		return new GankIoDetailModel();
	}


}
