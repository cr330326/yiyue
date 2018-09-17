package net.cryallen.yiyue.contract.discover;

import net.cryallen.androidlib.base.BasePresenter;
import net.cryallen.androidlib.base.IBaseFragment;
import net.cryallen.androidlib.base.IBaseModel;

/***
 Created by chenran on 2018/9/15.
 ***/
public interface DiscoverMainContract {

	//Discover主页接口
	abstract class DiscoverMainPresenter extends BasePresenter<IDiscoverMainModel, IDiscoverMainView> {
		public abstract void getTabList();
	}

	interface IDiscoverMainModel extends IBaseModel {
		String[] getTabs();
	}

	interface IDiscoverMainView extends IBaseFragment {
		void showTabList(String[] tabs);
	}
}
