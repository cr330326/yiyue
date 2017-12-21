package net.cryallen.androidlib.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chenran3 on 2017/10/24.
 */

public abstract class BaseFragment extends Fragment {

	protected LayoutInflater mInflater;

	public BaseApplication getApplication() {
		return (BaseApplication) getActivity().getApplication();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.mInflater = inflater;
		View view = super.onCreateView(inflater, container, savedInstanceState);
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	public  boolean onBackPressed() {
		return false;
	}

	protected View inflateView(int resId) {
		return this.mInflater.inflate(resId, null);
	}

	protected abstract int getLayoutId();

	protected abstract void initView(View view);

	protected abstract void initData();
}
