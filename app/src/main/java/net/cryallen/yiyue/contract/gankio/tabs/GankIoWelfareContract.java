package net.cryallen.yiyue.contract.gankio.tabs;

import net.cryallen.yiyue.bean.gankio.GankIoWelfareItemBean;
import net.cryallen.yiyue.bean.gankio.GankIoWelfareListBean;
import net.cryallen.yiyue.contract.tabs.BaseTabsContract;

import io.reactivex.Observable;

/***
 Created by chenran on 2018/9/17.
 ***/
public interface GankIoWelfareContract {

	abstract class GankIoWelfarePresenter extends BaseTabsContract
			.BaseTabsPresenter<IGankIoWelfareModel, IGankIoWelfareView, GankIoWelfareItemBean> {

	}

	interface IGankIoWelfareModel extends BaseTabsContract.IBaseTabsModel {
		/**
		 * 获取福利list
		 *
		 * @param pre_page 每页条数
		 * @param page     当前页
		 * @return Observable
		 */
		Observable<GankIoWelfareListBean> getWelfareList(int pre_page, int page);
	}

	interface IGankIoWelfareView extends BaseTabsContract.IBaseTabsView<GankIoWelfareItemBean> {
	}
}
