package com.example.dagger.demo1.base.shoe;

import com.example.dagger.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Description： PracticeDemo
 * Copyright (c)
 * This program is protected by copyright laws.
 * package: com.example.dagger
 * Date: 2017/5/11
 * user: user QuintoQin
 *
 * @author 覃勤
 * @version : 1.0
 */

//相当于一个中介人，将商品从工厂运出来买个客户
@Singleton
//@PerActivity
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
