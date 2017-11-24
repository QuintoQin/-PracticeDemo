package com.example.rxjava2.memory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.rxjava2.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

public class MemoryActivity extends AppCompatActivity {
    private static final String TAG = "RxJava";
    String memoryCache = null;
    String diskCache = "从磁盘缓存中获取数据";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        Observable<String> memory = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                if (memoryCache != null) {
                    e.onNext(memoryCache);
                } else {
                    e.onComplete();
                }
            }
        });
        Observable<String> disk = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                if (diskCache != null) {
                    e.onNext(diskCache);
                } else {
                    e.onComplete();
                }
            }
        });
        Observable<String> network = Observable.just("从网络中获取数据");

        Observable.concat(memory, disk, network)
                .firstElement()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG, s);
                    }
                });

    }
}
