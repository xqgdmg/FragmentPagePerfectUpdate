package com.example.mainframework03.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * 注册监听
 * 
 */
public class BaseFragment extends Fragment {

	public interface OnEventListener {
		public void onEvent(int what, Bundle data, Object object);
	}

	protected OnEventListener onEventListener = null;

	public BaseFragment() {
		super();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			onEventListener = (OnEventListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + "must implement " + OnEventListener.class);
		}
	}
}