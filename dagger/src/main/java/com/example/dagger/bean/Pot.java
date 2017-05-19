package com.example.dagger.bean;

import javax.inject.Inject;

/**
 * Description： PracticeDemo
 * Copyright (c)
 * This program is protected by copyright laws.
 * package: com.example.dagger.bean
 * Date: 2017/5/18
 * user: user QuintoQin
 *
 * @author 覃勤
 * @version : 1.0
 */
public class Pot {
    private Rose rose;

    @Inject
    public Pot(Rose rose) {
        this.rose = rose;
    }

    public String show() {
        return rose.whister();
    }
}
