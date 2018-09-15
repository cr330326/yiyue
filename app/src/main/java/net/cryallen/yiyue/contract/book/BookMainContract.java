package net.cryallen.yiyue.contract.book;

import net.cryallen.androidlib.base.BasePresenter;
import net.cryallen.androidlib.base.IBaseFragment;
import net.cryallen.androidlib.base.IBaseModel;

/***
 Created by chenran on 2018/9/15.
 ***/
public interface BookMainContract {

	//book主页接口
	abstract class BookMainPresenter extends BasePresenter<IBookMainModel, IBookMainView> {
		public abstract void getTabList();
	}

	interface IBookMainModel extends IBaseModel {
		String[] getTabs();
	}

	interface IBookMainView extends IBaseFragment {
		void showTabList(String[] tabs);
	}
}
