package net.cryallen.yiyue.model.detail;

import android.support.annotation.NonNull;

import net.cryallen.androidlib.base.BaseModel;
import net.cryallen.yiyue.contract.detail.WebViewLoadConaract;

/***
 Created by chenran on 2018/9/30.
 ***/
public class WebViewLoadModel extends BaseModel implements WebViewLoadConaract.IWebViewLoadModel {
	@NonNull
	public static WebViewLoadModel newInstance() {
		return new WebViewLoadModel();
	}
}
