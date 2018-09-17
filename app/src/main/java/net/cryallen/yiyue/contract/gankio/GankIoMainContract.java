package net.cryallen.yiyue.contract.gankio;

import net.cryallen.androidlib.base.BasePresenter;
import net.cryallen.androidlib.base.IBaseFragment;
import net.cryallen.androidlib.base.IBaseModel;

/***
 Created by chenran on 2018/9/17.
 ***/
public interface GankIoMainContract {

	//主页接口
	abstract class GankIoMainPresenter extends BasePresenter<IGankIoMainModel, IGankIoMainView> {
		public abstract void getTabList();
	}

	interface IGankIoMainModel extends IBaseModel {
		String[] getTabs();
	}

	interface IGankIoMainView extends IBaseFragment {
		void showTabList(String[] tabs);
	}
}
