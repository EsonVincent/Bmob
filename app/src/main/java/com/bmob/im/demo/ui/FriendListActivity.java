package com.bmob.im.demo.ui;

import android.os.Bundle;

import com.eson.cn.R;

/**
 * Created by Eson on 2016/8/29.
 */
public class FriendListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petfriend);
        initView();
    }

    private void initView() {

        initTopBarForOnlyTitle("宠物圈");
    }
}
