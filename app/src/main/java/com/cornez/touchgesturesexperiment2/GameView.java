package com.cornez.touchgesturesexperiment2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

    private Circle mCircle;
    // STAN'S ADDITIONS
    private Line mLine;
    // default shape is circle
    private  Rectangle mRectangle;
    private Oval mOval;
    private String shape;

    // Coordinates of points to draw
    private float x1 = (float)300;
    private float x2 = (float)500;
    private float y1 = (float)200;
    private float y2 = (float)400;


    public GameView(Context context) {
        super(context);

        // set default shape to circle
        shape = "circle";
        //CREATE A CIRCLE at initial location
        mCircle = new Circle();
        mLine = new Line();
        mRectangle = new Rectangle();
        mOval = new Oval();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //TASK 1: FILL THE BACKGROUND OF THE CANVAS
        canvas.drawRGB(248, 232, 198);

        //TASK 2: DRAW THE SHAPE
        switch(shape) {
            case "circle":
                mCircle.setBounds(new RectF(x1, y1, x2, y2));
                canvas.drawCircle(mCircle.getX(), mCircle.getY(),
                        mCircle.getRadius(), mCircle.getPaint());
                break;
            case "line":
                // set line values
                mLine.setStart(x1, y1);
                mLine.setEnd(x2, y2);
                // draw the line
                canvas.drawLine(mLine.getX1(), mLine.getY1(),
                        mLine.getX2(), mLine.getY2(),
                        mLine.getPaint());
                break;
            case "rectangle":
                mRectangle.setBounds(x1, y1, x2, y2);
                // draw the Rect
                canvas.drawRect(mRectangle.getX1(), mRectangle.getY1(),
                        mRectangle.getX2(), mRectangle.getY2(),
                        mRectangle.getPaint());
                break;
            case "oval":
                mOval.setBounds(new RectF(x1, y1, x2, y2));
                canvas.drawOval(mOval.getBoundingRect(),
                        mOval.getPaint());
                break;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //TASK 1:  IDENTIFY THE TOUCH ACTION BEING PERFORMED
        int touchAction = event.getActionMasked();

        //TASK 2:  RESPOND TO TWO POSSIBLE TOUCH EVENTS
        switch (touchAction) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                x2 = x1;
                y2 = y1;
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                x2 = event.getX();
                y2 = event.getY();
                break;
        }

        //TASK 3: INVALIDATE THE VIEW
        invalidate();

        //TASK 4: RETURNS A TRUE AFTER HANDLING THE TOUCH ACTION EVENT
        return true;
    }

    // STAN'S ADDITIONS
    public void setShape(String shape) {
        this.shape = shape;
    }
}
