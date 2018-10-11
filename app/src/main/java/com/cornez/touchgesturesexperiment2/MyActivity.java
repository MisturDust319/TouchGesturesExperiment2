package com.cornez.touchgesturesexperiment2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class MyActivity extends Activity {

    // STAN'S ADDITIONS
    // shape enum
    String currentShape;
    GameView curView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentShape = "circle";
        curView = new GameView(this);

        setContentView(curView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.menuitem_circle) {
            currentShape = "circle";
        }
        else if (id == R.id.menuitem_line) {
            currentShape = "line";
        }
        // now set the shape in the GameView
        curView.setShape(currentShape);

        return super.onOptionsItemSelected(item);
    }
}
