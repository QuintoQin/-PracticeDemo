package com.example.user.practicedemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.practicedemo.service.CommonDialogFragment;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        CommonDialogFragment commonDialogFragment = new CommonDialogFragment();
        commonDialogFragment.show(getSupportFragmentManager(),"CommonDialogFragment");
    }
}
