package com.example.user.practicedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "rx";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
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
        Observable<Long> sender = Observable.timer(3, TimeUnit.SECONDS).repeat(3);
        Observer<Long> receiver = new Observer<Long>() {
            @Override
            public void onCompleted() {
                Log.e(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onNext(Long s) {
                Log.e(TAG,String.valueOf(s));
            }
        };

        sender.subscribe(receiver);
    }
}
