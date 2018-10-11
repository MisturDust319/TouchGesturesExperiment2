package com.cornez.touchgesturesexperiment2;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Rectangle {
    // paint is used to set a color
    private Paint mPaint;
    // STAN'S ADDITIONS
    // start and end coord.
    private float mX1, mY1;
    private float mX2, mY2;

//    private RectF boundedRect;
    // set line

    public Rectangle() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
    }

//    public Circle(RectF bRect) {
//        this();
//        this.setBounds(bRect);
//    }

    public void setBounds(float x1, float y1, float x2, float y2) {
        mX1 = x1;
        mY1 = y1;
        mX2 = x2;
        mY2 = y2;
    }

    public void setPaint(Paint paint) {
        mPaint = paint;
    }
    public Paint getPaint() {
        return mPaint;
    }

    public float getX1() {
        return  mX1;
    }

    public float getX2() {
        return  mX2;
    }

    public float getY1() {
        return  mY1;
    }

    public float getY2() {
        return  mY2;
    }
}
