package com.example.figurasaleatorias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DrawShapes1 extends AppCompatActivity {
    private RandomShapeView mDrawingArea;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_shapes1);
        mDrawingArea  = (RandomShapeView)findViewById(R.id.drawing_area);
    }

    /** Handles events for the button. Redraws the ShapeView. */
    public void redraw(View clickedButton) {
        mDrawingArea.invalidate();
    }
}