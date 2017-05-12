package com.example.greendao.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Description： PracticeDemo
 * Copyright (c)
 * This program is protected by copyright laws.
 * package: com.example.greendao.dao
 * Date: 2017/5/12
 * user: user QuintoQin
 *
 * @author 覃勤
 * @version : 1.0
 */
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    @Transient
    private int tempUsageCount;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 873297011)
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 586692638)
    public User() {
    }
}
