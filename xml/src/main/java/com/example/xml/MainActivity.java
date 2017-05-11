package com.example.xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button dom;
    TextView dom_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        dom = (Button) findViewById(R.id.dom);
        dom_tv = (TextView) findViewById(R.id.dom_tv);

    }
}
