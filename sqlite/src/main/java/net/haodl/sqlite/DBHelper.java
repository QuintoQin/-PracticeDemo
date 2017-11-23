package net.haodl.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 26050 on 2017/11/15.
 */

public class DBHelper extends SQLiteOpenHelper{
    //数据库名称
    private static final String DBName = "study.db";
    //数据库版本
    private static final int DBVersion = 1;

    public DBHelper(Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
        db.execSQL("CREATE TABLE study ( _id integer PRIMARY KEY AUTOINCREMENT NOT NULL, bookName varchar, bookDesc varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS study");
        onCreate(db);
    }
}
