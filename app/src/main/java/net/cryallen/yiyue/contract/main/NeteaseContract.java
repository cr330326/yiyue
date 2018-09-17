package net.cryallen.yiyue.contract.main;

import net.cryallen.yiyue.bean.netease.NeteaseNewsItemBean;
import net.cryallen.yiyue.bean.netease.NeteaseNewsListBean;
import net.cryallen.yiyue.contract.tabs.BaseTabsContract;

import io.reactivex.Observable;

/***
 * 网易新闻接口
 Created by chenran on 2018/9/16.
 ***/
public interface NeteaseContract {
	abstract class WangyiPresenter extends BaseTabsContract.BaseTabsPresenter<INeteaseModel,
			INeteaseView, NeteaseNewsItemBean> {
	}

	interface INeteaseModel extends BaseTabsContract.IBaseTabsModel {
		/**
		 * 获取网易新闻list
		 *
		 * @param id id
		 * @return Observable
		 */
		Observable<NeteaseNewsListBean> getNewsList(int id);
	}

	interface INeteaseView extends BaseTabsContract.IBaseTabsView<NeteaseNewsItemBean> {
	}
}
