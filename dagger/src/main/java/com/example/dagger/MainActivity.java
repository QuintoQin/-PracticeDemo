package com.example.dagger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtil.inject(this);
        button.setText("Hello");

    }

    @OnClick(R.id.btn)
    public void click() {
        Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_LONG).show();
    }
}
