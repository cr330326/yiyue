package net.cryallen.yiyue.contract.detail;
import net.cryallen.yiyue.presenter.detail.BaseWebViewLoadPresenter;

/***
 * 微信精选详情页接口
 Created by chenran on 2018/9/16.
 ***/
public interface WeixinDetailContract {
	abstract class WeixinDetailPresenter extends BaseWebViewLoadPresenter<IWeixinDetailModel,
			IWeixinDetailView> {
		/**
		 * 加载微信精选详情
		 *
		 * @param url url
		 */
		public abstract void loadWeixinChoiceDetail(String url);
	}

	interface IWeixinDetailModel extends BaseWebViewLoadContract.IBaseWebViewLoadModel {
	}

	interface IWeixinDetailView extends BaseWebViewLoadContract.IBaseWebViewLoadView {
		/**
		 * 显示微信精选详细内容
		 *
		 * @param url url
		 */
		void showWeixinChoiceDetail(String url);
	}
}
