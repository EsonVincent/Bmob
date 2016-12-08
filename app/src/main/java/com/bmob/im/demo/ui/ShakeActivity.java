package com.bmob.im.demo.ui;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.eson.cn.R;

/**
 * Created by Eson on 2016/9/6.
 */
public class ShakeActivity extends BaseActivity implements SensorEventListener {

    private LinearLayout topLayout;
    private ImageView topLine;
    private LinearLayout bottomLayout;
    private ImageView bottomLine;
    private SensorManager sensorManager;
    private Vibrator vibrator;
    private boolean isShake = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        topLayout = (LinearLayout) findViewById(R.id.shake_top_layout);
        topLine = (ImageView) findViewById(R.id.shake_top_line);
        bottomLayout = (LinearLayout) findViewById(R.id.shake_bottom_layout);
        bottomLine = (ImageView) findViewById(R.id.shake_bottom_line);
        topLine.setVisibility(View.GONE);
        bottomLine.setVisibility(View.GONE);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
    }


    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener( this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener( this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        int sensorType = event.sensor.getType();
        // values[0]:X轴，values[1]：Y轴，values[2]：Z轴
        float[] values = event.values;
        if (sensorType == Sensor.TYPE_ACCELEROMETER) {
            if ((Math.abs(values[0]) > 17 || Math.abs(values[1]) > 17 || Math
                    .abs(values[2]) > 17) && !isShake) {
                isShake = true;
                new Thread() {
                    public void run() {
                        try {
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    // 摇动手机后，再伴随震动提示~~
                                    vibrator.vibrate(300);
                                    topLine.setVisibility(View.VISIBLE);
                                    bottomLine.setVisibility(View.VISIBLE);
                                    startAnimation(false);
                                }
                            });
                            Thread.sleep(500);
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    // 摇动手机后，再伴随震动提示~~
                                    vibrator.vibrate(300);
                                }
                            });
                            Thread.sleep(500);
                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    isShake = false;
                                    startAnimation(true);
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private void startAnimation(boolean isBack) {
        int type = TranslateAnimation.RELATIVE_TO_SELF;
        float topFromYValue;
        float topToYValue;
        float bottomFromYValue;
        float bottomToYValue;
        if (isBack) {
            topFromYValue = -0.5f;
            topToYValue = 0;
            bottomFromYValue = 0.5f;
            bottomToYValue = 0;
        } else {
            topFromYValue = 0;
            topToYValue = -0.5f;
            bottomFromYValue = 0;
            bottomToYValue = 0.5f;
        }
        TranslateAnimation topAnimation = new TranslateAnimation(type, 0, type,
                0, type, topFromYValue, type, topToYValue);
        topAnimation.setDuration(200);
        topAnimation.setFillAfter(true);
        TranslateAnimation bottomAnimation = new TranslateAnimation(type, 0,
                type, 0, type, bottomFromYValue, type, bottomToYValue);
        bottomAnimation.setDuration(200);
        bottomAnimation.setFillAfter(true);
        if (isBack) {
            bottomAnimation
                    .setAnimationListener(new TranslateAnimation.AnimationListener() {

                        @Override
                        public void onAnimationStart(Animation animation) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            // TODO Auto-generated method stub
                            topLine.setVisibility(View.GONE);
                            bottomLine.setVisibility(View.GONE);
                        }
                    });
        }
        bottomLayout.startAnimation(bottomAnimation);
        topLayout.startAnimation(topAnimation);
    }
}
