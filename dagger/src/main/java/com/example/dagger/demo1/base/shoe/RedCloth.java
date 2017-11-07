package com.example.dagger.demo1.base.shoe;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

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

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface RedCloth {

}
