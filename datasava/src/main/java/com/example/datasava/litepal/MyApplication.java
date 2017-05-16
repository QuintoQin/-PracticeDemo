package com.example.datasava.litepal;

import android.app.Application;

import org.litepal.LitePal;

/**
 * Description： PracticeDemo
 * Copyright (c)
 * This program is protected by copyright laws.
 * package: com.example.datasava.litepal
 * Date: ${date}
 * user: 覃勤 QuintoQin
 *
 * @author 覃勤
 * @version : 1.0
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
