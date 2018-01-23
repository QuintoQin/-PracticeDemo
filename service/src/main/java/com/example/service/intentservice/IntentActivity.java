package com.example.service.intentservice;

import android.content.Intent;
import android.os.Binder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.service.R;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        startService(new Intent(IntentActivity.this, MyIntentService.class));
        Binder binder = new Binder();
    }
}
