package com.example.view.simple;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by ${user} on 2017/12/25.
 * QinQin
 */

public class MyView extends LinearLayout {
    private boolean s1 = true;
    private Scroller scroller;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
    }

    //调用此方法滚动到目标位置
    public void scroll() {
        scroller.startScroll(0, 0, 500, 0, 3000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();
        }
    }

    public void beginScroll() {
        if (!s1) {
            scroller.startScroll(0, 0, 0, 0, 3000);
            s1 = true;
        } else {
            scroller.startScroll(0, 0, -1000, 0, 3000);
            s1 = false;
        }
        invalidate();
    }


}
