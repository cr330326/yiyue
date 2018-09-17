package net.cryallen.yiyue.contract.detail;
import net.cryallen.yiyue.presenter.detail.BaseWebViewLoadPresenter;

/***
 Created by chenran on 2018/9/16.
 ***/
public interface GankIoDetailContract {

	abstract class GankIoDetailPresenter extends BaseWebViewLoadPresenter<IGankIoDetailModel,
					IGankIoDetailView> {
		/**
		 * 加载GankIo详情
		 *
		 * @param url url
		 */
		public abstract void loadGankIoDetail(String url);
	}

	interface IGankIoDetailModel extends BaseWebViewLoadContract.IBaseWebViewLoadModel {
	}

	interface IGankIoDetailView extends BaseWebViewLoadContract.IBaseWebViewLoadView {
		/**
		 * 显示GankIo详细内容
		 *
		 * @param url url
		 */
		void showGankIoDetail(String url);
	}
}
