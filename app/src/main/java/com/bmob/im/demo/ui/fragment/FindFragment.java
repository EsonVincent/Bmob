package com.bmob.im.demo.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bmob.im.demo.ui.FragmentBase;
import com.bmob.im.demo.ui.FriendListActivity;
import com.bmob.im.demo.ui.GameActivity;
import com.bmob.im.demo.ui.ScanActivity;
import com.bmob.im.demo.ui.ShakeActivity;
import com.bmob.im.demo.ui.ShopActivity;
import com.eson.cn.R;

/**
 * Created by Eson on 2016/8/23.
 */
public class FindFragment extends FragmentBase {
    private LinearLayout ll_playgame;
    private LinearLayout ll_scan;
    private LinearLayout ll_petfriend;
    private LinearLayout ll_shake;
    private LinearLayout ll_shop;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

    }

    private void initView() {
        initTopBarForOnlyTitle("宠圈");
        ll_playgame= (LinearLayout) findViewById(R.id.ll_playgame);
        ll_playgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), GameActivity.class);
                startActivity(intent);
            }
        });
        ll_petfriend= (LinearLayout) findViewById(R.id. ll_petfriend);
        ll_petfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), FriendListActivity.class);
                startActivity(intent);
            }
        });

        ll_shake= (LinearLayout) findViewById(R.id. ll_shake);
        ll_shake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ShakeActivity.class);
                startActivity(intent);
            }
        });
        ll_scan= (LinearLayout) findViewById(R.id.ll_scan);
        ll_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ScanActivity.class);
                startActivity(intent);
            }
        });
        ll_shop= (LinearLayout) findViewById(R.id.ll_shop);
        ll_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ShopActivity.class);
                startActivity(intent);
            }
        });
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
