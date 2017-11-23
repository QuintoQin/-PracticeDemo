package net.haodl.sqlite;

import android.app.Application;

/**
 * Created by 26050 on 2017/11/15.
 */

public class MyApp extends Application {
    //数据库辅助类实例
    private static DBHelper mDBHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        mDBHelper = new DBHelper(getApplicationContext());
    }

    //返回DBHelper实例
    public static DBHelper getmDBHelper() {
        return mDBHelper;
    }
}
