package com.example.dagger;

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
//类似一个商品
public class Cloth {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color + "布料";
    }
}
