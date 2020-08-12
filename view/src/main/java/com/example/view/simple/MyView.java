package com.example.view.simple;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
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

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                intercepted = false;
                break;
            }
            case MotionEvent.ACTION_MOVE: {
//                if (父容器需要当前点击事件) {
//                    intercepted = true;
//                } else {
//                    intercepted = false;
//                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                intercepted = false;
                break;
            }
            default:
                break;
        }
        return intercepted;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
//                if (父容器需要此类点击事件) {
//                    getParent().requestDisallowInterceptTouchEvent(false);
//                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
}
}
