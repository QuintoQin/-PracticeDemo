//package com.example.dagger;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.Toast;
//
//import com.example.dagger.demo1.base.bean.Pot;
//
//import javax.inject.Inject;
//
//public class SimpleActivity extends AppCompatActivity {
//
//    @Inject
//    Pot pot;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_simple);
//        // 这个类是重新编译后Dagger2自动生成的，所以写这行代码之前要先编译一次
//        // Build --> Rebuild Project
//        //DaggerSimpleComponent.create().Inject(this);
//        String show = pot.show();
//        Toast.makeText(this, show, Toast.LENGTH_LONG).show();
//    }
//}
