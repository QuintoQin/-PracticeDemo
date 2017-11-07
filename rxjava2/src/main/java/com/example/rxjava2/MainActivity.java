package com.example.rxjava2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "RxJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                Log.e(TAG, "Observable:" + Thread.currentThread().getName());
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        });
//        Observer<Integer> observer = new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.e(TAG, "subscribe");
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                Log.e(TAG, "" + value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "error");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.e(TAG, "complete");
//            }
//        };
//        Consumer<Integer> consumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.e(TAG, "Observer:" + Thread.currentThread().getName());
//                Log.e(TAG, "onNext===" + integer);
//            }
//        };
//        observable.subscribeOn(Schedulers.newThread()).
//                observeOn(AndroidSchedulers.mainThread()).
//                subscribe(consumer);
        //Log.e(TAG,Thread.currentThread().getName());
    }
}
