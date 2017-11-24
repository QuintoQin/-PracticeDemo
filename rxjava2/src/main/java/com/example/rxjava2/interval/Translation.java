package com.example.rxjava2.interval;

import android.util.Log;

/**
 * Created by 26050 on 2017/11/23.
 */

public class Translation {
    private int status;

    private content content;
    private static class content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    //定义 输出返回数据 的方法
    public void show() {
        Log.e("RxJava", content.out );
    }

}
