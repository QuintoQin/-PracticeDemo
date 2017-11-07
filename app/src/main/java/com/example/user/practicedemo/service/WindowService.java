package com.example.user.practicedemo.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.user.practicedemo.R;

/**
 * Description： PracticeDemo
 * Copyright (c)
 * This program is protected by copyright laws.
 * package: com.example.user.practicedemo.service
 * Date: 2017/7/4
 * user: user QuintoQin
 *
 * @author 覃勤
 * @version : 1.0
 */
public class WindowService extends Service {
    WindowManager windowManager;
    ImageView imageView;

    public WindowService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (imageView == null) {
            installWindow();
        }
        return START_STICKY;

    }

    private void installWindow() {
        imageView = new ImageView(this.getBaseContext());
        imageView.setImageResource(R.mipmap.ic_launcher);
        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSPARENT;
        layoutParams.width = 200;
        layoutParams.height = 200;
        layoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_FULLSCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        windowManager.addView(imageView,layoutParams);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                layoutParams.x = (int) (event.getRawX() - 100);
                layoutParams.y = (int) (event.getRawY() - 100);
                return true;
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (imageView != null) {
            windowManager.removeView(imageView);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
