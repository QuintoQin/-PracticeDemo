package com.jrkg.jetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;

import com.jrkg.jetpack.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        final User user = new User();
        user.setFirstName("Qin");
        binding.setUser(user);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                user.setFirstName("QQQ");
            }
        },5000);
    }
}
