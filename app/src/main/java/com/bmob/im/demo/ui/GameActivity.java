package com.bmob.im.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.eson.cn.R;

/**
 * Created by Eson on 2016/8/24.
 */
public class GameActivity extends BaseActivity{
    private LinearLayout  wuziqi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgame);
        initView();
    }

    private void initView() {
        initTopBarForOnlyTitle("玩游戏");
        wuziqi= (LinearLayout) findViewById(R.id.ll_wuziqi);
        wuziqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GameActivity.this,PlayGameActivity.class);
                startActivity(intent);
            }
        });
    }


}
