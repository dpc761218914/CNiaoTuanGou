package com.dpc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义View实现流程
 * Created by Administrator on 2017/5/24 0024.
 */

public class MyView extends View {

    private Paint mPaint;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    //测量View控件
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }

    //绘制控件
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画布
        //绘制一个圆
        canvas.drawCircle(60,60,60,mPaint);
        //绘制文本
        canvas.drawText("深夜录视频",100,100,mPaint);
        //绘制直线
        canvas.drawLine(100,100,150,150,mPaint);
        //绘制路径
        Path path = new Path();
        //移动到一个点
        path.moveTo(60,60);
        //绘制直线
        path.lineTo(60,60);
        path.lineTo(120,0);
        path.lineTo(180,120);
        path.moveTo(120,0);
        path.moveTo(180,120);
        //图形闭合
        path.close();
        canvas.drawPath(path,mPaint);
        //绘制点
        //绘制椭圆,扇形,环形
        //绘制Bitmap
    }


    @NonNull
    private Paint initPaint() {
        //画笔
        mPaint = new Paint();
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //设置画笔的宽度
        mPaint.setStrokeWidth(5);
        //设置画笔的颜色
        mPaint.setColor(Color.BLUE);
        //设置画笔的样式
        mPaint.setStyle(Paint.Style.STROKE);
        //设置文本字体的大小
        mPaint.setTextSize(20);

        return mPaint;
    }
}
