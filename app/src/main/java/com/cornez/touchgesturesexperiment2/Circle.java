package com.cornez.touchgesturesexperiment2;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Circle {

    // paint is used to set a color
    private Paint mPaint;
    private float mRadius;
    private float centerX;
    private float centerY;
    private RectF boundedRect;
    // set line

    public Circle() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
    }

    public Circle(RectF bRect) {
        this();
        this.setBounds(bRect);
    }

    public void setBounds(RectF bRect) {
        boundedRect = bRect;
        boundedRect.sort();
        centerX = boundedRect.centerX();
        centerY = boundedRect.centerY();
        mRadius = Math.max(boundedRect.height(), boundedRect.width())/2;
    }

    public void setPaint(Paint paint) {
        mPaint = paint;
    }
    public Paint getPaint() {
        return mPaint;
    }

    public float getRadius() {
       return  mRadius;
    }

    public float getX() {
        return  centerX;
    }

    public float getY() {
        return  centerY;
    }
}
