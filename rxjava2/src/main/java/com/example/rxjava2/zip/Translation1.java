package com.example.rxjava2.zip;

import android.util.Log;

/**
 * Created by 26050 on 2017/11/23.
 */

public class Translation1 {
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
    public String show() {
        return ("第一次翻译=" + content.out);
    }

}
