package com.example.service;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private ThreadLocal<Boolean> mThreadLocal = new ThreadLocal<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mThreadLocal.set(true);
        Log.e("thread", "result:" + mThreadLocal.get());
        new Thread("Thread#1") {
            @Override
            public void run() {
                super.run();
                mThreadLocal.set(false);
                Log.e("thread", "result:" + mThreadLocal.get());
            }
        }.start();
        new Thread("Thread#2") {
            @Override
            public void run() {
                super.run();
                Log.e("thread", "result:" + mThreadLocal.get());
            }
        }.start();
    }
}
