package com.example.view.simple;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.view.R;

/**
 * Created by 26050 on 2017/7/17.
 */

public class CustomTitleView extends View{
    private String mTitleText;
    private int mTitleTextColor;
    private int mTitleTextSize;

    private Rect mBound;
    private Paint mPaint;


    public CustomTitleView(Context context) {
        super(context);
    }

    public CustomTitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.CustomTitleView,defStyleAttr,0);


    }
}
