package com.bmob.im.demo.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bmob.im.demo.ui.FragmentBase;
import com.bmob.im.demo.ui.SetActivity;
import com.eson.cn.R;

/**
 * 设置
 * @ClassName: SetFragment
 */
@SuppressLint("SimpleDateFormat")
public class MeFragment extends FragmentBase{
	private LinearLayout ll_setting;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


		View view=inflater.inflate(R.layout.fragment_me, null);

		ll_setting= (LinearLayout) view.findViewById(R.id.ll_setting);
		ll_setting.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),SetActivity.class);
				startActivity(intent);
			}
		});
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initView();

	}

	private void initView() {
		initTopBarForOnlyTitle("我");

	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
	}
}
