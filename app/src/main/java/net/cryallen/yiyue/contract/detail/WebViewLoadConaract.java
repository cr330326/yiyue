package net.cryallen.yiyue.contract.detail;

import net.cryallen.yiyue.presenter.detail.BaseWebViewLoadPresenter;

/***
 * webview加载更多详情，传入url显示webview
 Created by chenran on 2018/9/16.
 ***/
public interface WebViewLoadConaract {

	abstract class WebViewLoadPresenter extends BaseWebViewLoadPresenter<IWebViewLoadModel,
					IWebViewLoadView> {
		/**
		 * 加载url
		 *
		 * @param url url
		 */
		public abstract void loadUrl(String url);
	}

	interface IWebViewLoadModel extends BaseWebViewLoadContract.IBaseWebViewLoadModel {
	}

	interface IWebViewLoadView extends BaseWebViewLoadContract.IBaseWebViewLoadView {
		/**
		 * 显示url详情
		 *
		 * @param url url
		 */
		void showUrlDetail(String url);
	}
}
