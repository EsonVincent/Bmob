package com.bmob.im.demo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.bmob.im.demo.view.WuziqiPanel;
import com.eson.cn.R;


/**
 * Created by Eson on 2016/8/18.
 */
public class PlayGameActivity extends Activity {

    private WuziqiPanel wuziqiPanel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);
        wuziqiPanel= (WuziqiPanel) findViewById(R.id.wuziqi);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if (id==R.id.action_settings){
            wuziqiPanel.restart();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
