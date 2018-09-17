package net.cryallen.yiyue.contract.detail;

import net.cryallen.yiyue.bean.netease.NeteaseNewsDetailBean;
import net.cryallen.yiyue.presenter.detail.BaseWebViewLoadPresenter;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/***
 * 网易新闻详情页接口
 Created by chenran on 2018/9/16.
 ***/
public interface NeteaseDetailContract {
	abstract class WangyiDetailPresenter extends BaseWebViewLoadPresenter<INeteaseDetailModel,
					INeteaseDetailView> {
		/**
		 * 加载新闻详情
		 *
		 * @param url url
		 */
		public abstract void loadNewsDetailWithUrl(String url);

		/**
		 * 加载新闻详情
		 * <p>
		 * 排版显示不好看，直接使用loadNewsDetailWithUrl
		 *
		 * @param id id
		 */
		public abstract void loadNewsDetailWithId(String id);
	}

	interface INeteaseDetailModel extends BaseWebViewLoadContract.IBaseWebViewLoadModel {
		/**
		 * 获取网易新闻详情
		 *
		 * @param id 新闻id
		 * @return ResponseBody
		 */
		Observable<ResponseBody> getNewsDetail(String id);
	}

	interface INeteaseDetailView extends BaseWebViewLoadContract.IBaseWebViewLoadView {
		/**
		 * 显示新闻详细内容
		 *
		 * @param bean bean
		 */
		void showNewsDetail(NeteaseNewsDetailBean bean);

		/**
		 * 显示新闻详细内容
		 *
		 * @param url url
		 */
		void showNewsDetail(String url);
	}
}
