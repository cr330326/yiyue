package net.cryallen.yiyue.contract.main;

import net.cryallen.yiyue.bean.zhihu.ZhihuDailyItemBean;
import net.cryallen.yiyue.bean.zhihu.ZhihuDailyListBean;
import net.cryallen.yiyue.contract.tabs.BaseTabsContract;

import io.reactivex.Observable;

/***
 * 知乎日报接口
 Created by chenran on 2018/9/16.
 ***/
public interface ZhihuContract {

	abstract class ZhihuPresenter extends BaseTabsContract.BaseTabsPresenter<IZhihuModel,
			IZhihuView, ZhihuDailyItemBean> {
	}

	interface IZhihuModel extends BaseTabsContract.IBaseTabsModel {
		/**
		 * 根据日期获取日报list --> 20170910
		 *
		 * @param date 日期
		 * @return Observable
		 */
		Observable<ZhihuDailyListBean> getDailyList(String date);

		/**
		 * 获取日报list
		 *
		 * @return Observable
		 */
		Observable<ZhihuDailyListBean> getDailyList();
	}

	interface IZhihuView extends BaseTabsContract.IBaseTabsView<ZhihuDailyItemBean> {
	}
}
