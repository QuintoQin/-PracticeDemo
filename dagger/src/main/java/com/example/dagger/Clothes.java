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
public class Clothes {
    private Cloth cloth;

    public Clothes(Cloth cloth) {
        this.cloth = cloth;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    @Override
    public String toString() {
        return cloth.getColor() + "衣服";
    }
}
