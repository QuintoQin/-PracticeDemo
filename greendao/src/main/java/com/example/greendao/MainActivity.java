package com.example.greendao;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.greendao.dao.User;
import com.example.greendao.dao.UserDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserDao mUserDao = MyApplication.getInstance().getDaoSession().getUserDao();
        User mUser = new User((long) 2,"qinqin");
        //mUserDao.insert()
    }
}
