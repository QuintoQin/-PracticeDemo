package com.example.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;

import com.example.view.simple.MyView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "View";
    private MyView myView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MyView) findViewById(R.id.myView);
        btn = (Button) findViewById(R.id.btn);

        //mView.smoothScrollTo();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.beginScroll();
            }
        });
        //Log.e(TAG, "slop:" + ViewConfiguration.get(this).getScaledTouchSlop());
    }

    //    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        Log.e(TAG, "Top:" + mView.getTop());
//        Log.e(TAG, "Left:" + mView.getLeft());
//        Log.e(TAG, "Right:" + mView.getRight());
//        Log.e(TAG, "Bottom:" + mView.getBottom());
//        Log.e(TAG, "x:" + mView.getX());
//        Log.e(TAG, "y:" + mView.getY());
//        Log.e(TAG, "translationX:" + mView.getTranslationX());
//        Log.e(TAG, "translationY:" + mView.getTranslationY());
//    }
//
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("ACTIVITY TAG", "点击");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
