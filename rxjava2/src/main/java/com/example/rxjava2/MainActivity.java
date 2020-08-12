package com.example.rxjava2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "RxJava";
    String result = "数据源来自 = ";

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
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//
//            }
//        }).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Integer value) {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
//        Observable.intervalRange(3,10,2,1, TimeUnit.SECONDS)
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.e(TAG, "开始采用subscribe连接");
//                    }
//
//                    @Override
//                    public void onNext(Long value) {
//                        Log.e(TAG, "接收到了事件"+ value  );
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e(TAG, "对Complete事件作出响应");
//                    }
//                });
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//            }
//        }).map(new Function<Integer, String>() {
//            @Override
//            public String apply(Integer integer) throws Exception {
//                return "使用map操作符 将事件" + integer + "的参数从整型" + integer + "变换成字符串类型" + integer;
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.e(TAG, s);
//            }
//        });
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//            }
//        }).flatMap(new Function<Integer, ObservableSource<String>>() {
//            @Override
//            public ObservableSource<String> apply(Integer integer) throws Exception {
//                final List<String> list = new ArrayList<String>();
//                for (int i = 0; i < 3; i++) {
//                    list.add("我是事件" + integer + "拆分后的子事件" + i);
//                }
//                return Observable.fromIterable(list);
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.e(TAG, s);
//            }
//        });

//        Observable.just(1, 2, 3, 4, 5).buffer(3, 1)
//                .subscribe(new Observer<List<Integer>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<Integer> value) {
//                        Log.e(TAG, "缓存区里的事件数量 = " + value.size());
//                        for (Integer myValue : value) {
//                            Log.e(TAG, "事件 = " + value);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e(TAG, "onComplete");
//                    }
//                });

//        Observable.concat(Observable.just(1, 2, 3), Observable.just(4, 5, 6),
//                Observable.just(7, 8, 9), Observable.just(10, 11, 12))
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer value) {
//                        Log.e(TAG, "接受了事件" + value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e(TAG, "onComplete");
//                    }
//                }); Observable.concat(Observable.just(1, 2, 3), Observable.just(4, 5, 6),
//                Observable.just(7, 8, 9), Observable.just(10, 11, 12))
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer value) {
//                        Log.e(TAG, "接受了事件" + value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e(TAG, "onComplete");
//                    }
//                });

//        Observable.concatArray(Observable.just(1, 2, 3), Observable.just(4, 5, 6),
//                Observable.just(7, 8, 9), Observable.just(10, 11, 12),Observable.just(13,14,15))
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer value) {
//                        Log.e(TAG, "接受了事件" + value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e(TAG, "onComplete");
//                    }
//                });

//        Observable.merge(Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS),
//                Observable.intervalRange(2, 3, 1, 1, TimeUnit.SECONDS))
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Long value) {
//                        Log.e(TAG, "接受到了事件" + value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e(TAG, "onComplete");
//                    }
//                });

//        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                Log.e(TAG, "被观察者1发送了事件1");
//                emitter.onNext(1);
//                // 为了方便展示效果，所以在发送事件后加入2s的延迟
//                Thread.sleep(1000);
//
//                Log.e(TAG, "被观察者1发送了事件2");
//                emitter.onNext(2);
//                Thread.sleep(1000);
//
//                Log.e(TAG, "被观察者1发送了事件3");
//                emitter.onNext(3);
//                Thread.sleep(1000);
//
//                emitter.onComplete();
//            }
//        }).subscribeOn(Schedulers.io()); // 设置被观察者1在工作线程1中工作
//
//        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                Log.e(TAG, "被观察者2发送了事件A");
//                emitter.onNext("A");
//                Thread.sleep(1000);
//
//                Log.e(TAG, "被观察者2发送了事件B");
//                emitter.onNext("B");
//                Thread.sleep(1000);
//
//                Log.e(TAG, "被观察者2发送了事件C");
//                emitter.onNext("C");
//                Thread.sleep(1000);
//
//                Log.e(TAG, "被观察者2发送了事件D");
//                emitter.onNext("D");
//                Thread.sleep(1000);
//
//                emitter.onComplete();
//            }
//        }).subscribeOn(Schedulers.newThread());
//
//        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
//            @Override
//            public String apply(Integer integer, String s) throws Exception {
//                return integer + s;
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.e(TAG, "onSubscribe");
//            }
//
//            @Override
//            public void onNext(String value) {
//                Log.e(TAG, "最终接受到的事件 = " + value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "onError");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.e(TAG, "onComplete");
//            }
//        });


//        Observable<String> network = Observable.just("网络");
//        Observable<String> file = Observable.just("本地文件");
//        Observable.merge(network, file)
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.e(TAG, "onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(String value) {
//                        Log.e(TAG, "数据源有: " + value);
//                        result += value + "+";
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e(TAG, "onComplete");
//                        Log.e(TAG, result);
//                    }
//                });
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onError(new Throwable("发生错误了"));
//            }
//        }).doOnEach(new Consumer<Notification<Integer>>() {
//            @Override
//            public void accept(Notification<Integer> integerNotification) throws Exception {
//                Log.e(TAG, "doOnEach:" + integerNotification.getValue());
//            }
//        }).doOnNext(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.e(TAG, "doOnNext:" + integer);
//            }
//        }).doAfterNext(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.e(TAG, "doAfterNext:" + integer);
//            }
//        }).doOnComplete(new Action() {
//            @Override
//            public void run() throws Exception {
//                Log.e(TAG, "doOnComplete");
//            }
//        }).doOnError(new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                Log.e(TAG, "doOnError:" + throwable.getMessage());
//            }
//        }).doOnSubscribe(new Consumer<Disposable>() {
//            @Override
//            public void accept(Disposable disposable) throws Exception {
//                Log.e(TAG, "doOnSubscribe:");
//            }
//        }).doAfterTerminate(new Action() {
//            @Override
//            public void run() throws Exception {
//                Log.e(TAG, "doAfterTerminate:");
//            }
//        }).doFinally(new Action() {
//            @Override
//            public void run() throws Exception {
//                Log.e(TAG, "doFinally");
//            }
//        }).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.e(TAG, "onSubscribe");
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                Log.e(TAG, "接收到事件" + value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "onError");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.e(TAG, "onComplete");
//            }
//        });

//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onError(new Exception("发送错误了"));
//                e.onNext(3);
//            }
//        }).retry()
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer value) {
//                        Log.e(TAG,"接受到了事件" + value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG,"onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e(TAG,"onComplete");
//                    }
//                });
    }
}
