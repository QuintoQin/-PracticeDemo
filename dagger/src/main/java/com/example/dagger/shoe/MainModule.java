package com.example.dagger.shoe;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
//类似于商品生产的工厂
@Module
public class MainModule {
//    @Provides
//    //@Named("red")
//    @RedCloth
//    public Cloth getRedCloth() {
//        Cloth cloth = new Cloth();
//        cloth.setColor("红色");
//        return cloth;
//    }

    @Singleton
    @Provides
    public Cloth getRedCloth() {
        Cloth cloth = new Cloth();
        cloth.setColor("红色");
        return cloth;
    }

//    @Provides
//    @Named("blue")//同个类提供不同的实例标识符
//    public Cloth getBlueCloth() {
//        Cloth cloth = new Cloth();
//        cloth.setColor("蓝色");
//        return cloth;
//    }

//    @Provides
//    public Cloth getCloth() {
//        Cloth cloth = new Cloth();
//        cloth.setColor("白色");
//        return cloth;
//    }
    @Provides
    public Clothes getClothes(Cloth cloth){
        return new Clothes(cloth);
    }
}
