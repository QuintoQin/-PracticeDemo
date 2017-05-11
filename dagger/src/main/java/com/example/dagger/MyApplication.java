//package com.example.dagger;
//
//import android.app.Application;
//
//import com.example.dagger.base.BaseComponent;
//import com.example.dagger.base.BaseModule;
//import com.example.dagger.base.DaggerBaseComponent;
//
///**
// * Description： PracticeDemo
// * Copyright (c)
// * This program is protected by copyright laws.
// * package: com.example.dagger
// * Date: 2017/5/11
// * user: user QuintoQin
// *
// * @author 覃勤
// * @version : 1.0
// */
//public class MyApplication extends Application{
//    private BaseComponent baseComponent;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        baseComponent = DaggerBaseComponent.builder().baseModule(new BaseModule()).build();
//    }
//}
