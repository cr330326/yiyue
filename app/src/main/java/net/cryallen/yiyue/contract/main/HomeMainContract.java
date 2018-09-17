package net.cryallen.yiyue.contract.main;

import net.cryallen.androidlib.base.BasePresenter;
import net.cryallen.androidlib.base.IBaseFragment;
import net.cryallen.androidlib.base.IBaseModel;

/***
 * 主页Contract
 Created by chenran on 2018/9/16.
 ***/
public interface HomeMainContract {
	//主页接口
	abstract class HomeMainPresenter extends BasePresenter<IHomeMainModel, IHomeMainView> {
		public abstract void getTabList();
	}

	interface IHomeMainModel extends IBaseModel {
		String[] getTabs();
	}

	interface IHomeMainView extends IBaseFragment {
		void showTabList(String[] tabs);
	}
}
