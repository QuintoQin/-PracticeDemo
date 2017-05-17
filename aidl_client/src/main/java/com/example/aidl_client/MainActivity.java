package com.example.aidl_client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aidl_service.IAIDLService1;

public class MainActivity extends AppCompatActivity {
    private Button bindService;
    //定义aidl接口变量
    private IAIDLService1 iaidlService1;
    //创建ServiceConnection的匿名类
    private ServiceConnection connection = new ServiceConnection() {
        //在Activity与Service建立关联时调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //使用AIDLService1.Stub.asInterface()方法获取服务器端返回的IBinder对象
            //将IBinder对象传换成了mAIDL_Service接口对象
            iaidlService1 = IAIDLService1.Stub.asInterface(service);

            try {
                iaidlService1.AIDLService();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        //重写onServiceConnected()方法和onServiceDisconnected()方法
        //在Activity与Service建立关联和解除关联的时候调用
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService = (Button) findViewById(R.id.bind_service);
        bindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.aidl_service.AIDL_Service1");

                intent.setPackage("com.example.aidl_service");

                bindService(intent, connection, Context.BIND_AUTO_CREATE);
            }
        });
    }
}
