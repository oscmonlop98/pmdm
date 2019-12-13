package com.example.figurasaleatorias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class DrawShapes2 extends AppCompatActivity {

    private TextView totalV;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_shapes2);
        totalV = (TextView) findViewById(R.id.muestraContador);

        View mostrar = findViewById(R.id.contador);
        mostrar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int numero = ShapeDrawableView.getContador();
                totalV.setText("Contador: " + numero);

                return false;
            }
        });

    }
}
