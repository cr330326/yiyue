package net.cryallen.yiyue.contract.detail;

import io.reactivex.Observable;

import net.cryallen.yiyue.bean.zhihu.ZhihuDailyDetailBean;
import net.cryallen.yiyue.presenter.detail.BaseWebViewLoadPresenter;

/***
 * 知乎日报详情页接口
 Created by chenran on 2018/9/16.
 ***/
public interface ZhihuDetailContract {

	abstract class ZhihuDetailPresenter extends BaseWebViewLoadPresenter<IZhihuDetailModel, IZhihuDetailView> {
		/**
		 * 加载日报详情
		 */
		public abstract void loadDailyDetail(String id);
	}

	interface IZhihuDetailModel extends BaseWebViewLoadContract.IBaseWebViewLoadModel {
		/**
		 * 获取日报详情
		 *
		 * @param id 日报id
		 * @return Observable
		 */
		Observable<ZhihuDailyDetailBean> getDailyDetail(String id);
	}

	interface IZhihuDetailView extends BaseWebViewLoadContract.IBaseWebViewLoadView {
		/**
		 * 显示日报详细内容
		 *
		 * @param bean ZhihuDailyDetailBean
		 */
		void showDailyDetail(ZhihuDailyDetailBean bean);
	}
}
