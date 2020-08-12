package com.example.service.handlerthread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.service.R;

public class HandlerThreadActivity extends AppCompatActivity {
    private TextView tv;

    private HandlerThread mCheckMsgThread;
    private Handler mCheckMsgHandler;
    private boolean isUpdataInfo;

    private static final int MSG_UPDATA_INFO = 0x110;

    //UI线程管理的handler
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);
        //创建后台线程
        initBackThread();
        tv = (TextView) findViewById(R.id.tv);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //开始查询
        isUpdataInfo = true;
        mCheckMsgHandler.sendEmptyMessage(MSG_UPDATA_INFO);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //停止查询
        isUpdataInfo = false;
        mCheckMsgHandler.removeMessages(MSG_UPDATA_INFO);
    }

    private void initBackThread() {
        mCheckMsgThread = new HandlerThread("check-message");
        mCheckMsgThread.start();
        mCheckMsgHandler = new Handler(mCheckMsgThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                checkForUpdata();
                if (isUpdataInfo) {
                    mCheckMsgHandler.sendEmptyMessageDelayed(MSG_UPDATA_INFO, 1000);
                }
            }
        };
    }

    //模拟服务器
    private void checkForUpdata() {
        try {
            Thread.sleep(1000);
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    int result = (int) (Math.random() * 3000 + 1000);
                    tv.setText(String.valueOf(result));
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCheckMsgThread.quit();
    }
}
