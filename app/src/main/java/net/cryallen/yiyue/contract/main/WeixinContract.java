package net.cryallen.yiyue.contract.main;

import net.cryallen.yiyue.bean.weixin.WeixinChoiceItemBean;
import net.cryallen.yiyue.bean.weixin.WeixinChoiceListBean;
import net.cryallen.yiyue.contract.tabs.BaseTabsContract;

import io.reactivex.Observable;

/***
 * 微信精选接口
 Created by chenran on 2018/9/16.
 ***/
public interface WeixinContract {
	abstract class WeixinPresenter extends BaseTabsContract.BaseTabsPresenter<IWeixinModel,
			IWeixinView, WeixinChoiceItemBean> {
	}

	interface IWeixinModel extends BaseTabsContract.IBaseTabsModel {
		/**
		 * 获取微信精选
		 *
		 * @param page      指定微信精选页数->空的话默认1
		 * @param pageStrip 每页显示条数->空的话默认20条
		 * @param dttype    返回数据的格式,xml或json，空的话->默认json
		 * @param key       聚合key
		 * @return Observable
		 */
		Observable<WeixinChoiceListBean> getWeixinChoiceList(int page, int pageStrip, String
				dttype, String key);
	}

	interface IWeixinView extends BaseTabsContract.IBaseTabsView<WeixinChoiceItemBean> {
	}
}
