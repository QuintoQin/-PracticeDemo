package com.example.user.practicedemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.ActivityCompat;

import com.example.user.practicedemo.service.WindowService;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "rx";
    private static final int MY_PERMISSIONS_REQUEST_STSTEM = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init();
        //check();
        //start();
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_STSTEM);
            }
        });


    }

    private void check() {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            //申请权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_STSTEM);
        } else {
            Toast.makeText(this, "已经申请了，所以开始把", Toast.LENGTH_LONG).show();
            start();
        }
    }

    private void start() {
        startService(new Intent(this, WindowService.class));
    }

    private void init() {
//        List<String> list = new ArrayList<>();
//        list.add("from1");
//        list.add("from2");
//        list.add("from3");
//        String[] s = {"from1","from2","from3"};
//        Observable<String> sender = Observable.defer(new Func0<Observable<String>>() {
//            @Override
//            public Observable<String> call() {
//                return Observable.just("defer");
//            }
//        });
//        Observable<Long> sender = Observable.timer(3, TimeUnit.SECONDS).repeat(3);
//        Observer<Long> receiver = new Observer<Long>() {
//            @Override
//            public void onCompleted() {
//                Log.e(TAG,"onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG,"onError");
//            }
//
//            @Override
//            public void onNext(Long s) {
//                Log.e(TAG,String.valueOf(s));
//            }
//        };
//
//        sender.subscribe(receiver);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_STSTEM: {
                // If request is cancelled, the result arrays are empty.
                if ( grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    start();
                } else {
                    Toast.makeText(this, "拒绝了你", Toast.LENGTH_LONG).show();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
