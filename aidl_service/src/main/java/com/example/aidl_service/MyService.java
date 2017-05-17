package com.example.aidl_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Description： PracticeDemo
 * Copyright (c)
 * This program is protected by copyright laws.
 * package: com.example.aidl_service
 * Date: 2017/5/17
 * user: user QuintoQin
 *
 * @author 覃勤
 * @version : 1.0
 */
public class MyService extends Service {
    private static final String TAG = "MyService";
    // 实例化AIDL的Stub类(Binder的子类)
    IAIDLService1.Stub mBinder = new IAIDLService1.Stub() {
        @Override
        public void AIDLService() throws RemoteException {
            Log.e(TAG, "do aidl service 客户端与远程后台通过AIDL成功通信");
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG,"执行了onBind()");
        //在onBind()返回继承自Binder的Stub类型的Binder，非常重要
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        Log.e(TAG,"onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG,"onDestroy()");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG,"onUnbind()");
        return super.onUnbind(intent);
    }
}
