package com.dpc.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/5/24 0024.
 */

public class indicator extends View {

    /**前景色的圆的画笔**/
    private Paint mForePaint;
    /**背景颜色的画笔**/
    private Paint mBgPaint;
    /**Indicator数量**/
    private int mNumber = 4;
    /**Indicator半径**/
    private int mRadius = 10;
    /**Indicator的背景色画笔颜色**/
    private int mBgColor = Color.RED;
    /**Indicator的前景色画笔颜色**/
    private int mForeColor = Color.BLUE;

    /***
     * 设置偏移量的方法
     * @param position
     * @param positionOffset
     */
    public void setOffset(int position,float positionOffset) {
        position %= mNumber;
        mOffset = position * 3 * mRadius + positionOffset * 3 * mRadius;
        //重绘
        invalidate();
    }

    /**移动的偏移量**/
    private float mOffset;

    public indicator(Context context) {
        super(context);
    }

    public indicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initPaint();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Indicator);
        mNumber = typedArray.getInteger(R.styleable.Indicator_setNumber, mNumber);
    }

    private void initPaint() {
        mForePaint = new Paint();
        mForePaint.setAntiAlias(true);
        mForePaint.setStyle(Paint.Style.FILL);
        mForePaint.setColor(mForeColor);
        mForePaint.setStrokeWidth(2);

        mBgPaint = new Paint();
        mBgPaint.setAntiAlias(true);
        mBgPaint.setStyle(Paint.Style.STROKE);
        mBgPaint.setColor(mBgColor);
        mBgPaint.setStrokeWidth(2);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mNumber; i++) {
            canvas.drawCircle(60 + i * mRadius * 3,60,mRadius,mBgPaint);
        }
        canvas.drawCircle(60 + mOffset,60,mRadius,mForePaint);
    }

}
