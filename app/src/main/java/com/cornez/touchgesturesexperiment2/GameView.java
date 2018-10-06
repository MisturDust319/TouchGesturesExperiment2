package com.cornez.touchgesturesexperiment2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

    private Circle mCircle;

    // Coordinates of points to draw
    private float x1 = (float)300;
    private float x2 = (float)500;
    private float y1 = (float)200;
    private float y2 = (float)400;

    public GameView(Context context) {
        super(context);

        //CREATE A CIRCLE at initial location
        mCircle = new Circle();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //TASK 1: FILL THE BACKGROUND OF THE CANVAS
        canvas.drawRGB(248, 232, 198);

        //TASK 2: DRAW THE CIRCLE
        mCircle.setBounds(new RectF(x1, y1, x2, y2));

        canvas.drawCircle(mCircle.getX(), mCircle.getY(),
                mCircle.getRadius(), mCircle.getPaint());
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
}
