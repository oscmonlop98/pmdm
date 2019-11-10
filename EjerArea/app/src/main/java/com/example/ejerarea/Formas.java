package com.example.ejerarea;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

    public class Formas extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(new MiDibujo(this));

        }

        public class MiDibujo extends View {
            public MiDibujo(Context contexto) {

                super(contexto);

            }

            @Override
            protected void onDraw(Canvas lienzo) {
                Paint pincel = new Paint();
                pincel.setColor(Color.BLUE);
                pincel.setStrokeWidth(15);
                pincel.setTextSize(50);
                pincel.setStyle(Paint.Style.FILL);

                int anchura = getWidth();
                int altura = getHeight();

                lienzo.drawCircle(150,150,80, pincel);
                lienzo.drawText("Esto es un círculo", 100, 800, pincel);


            }
        }
    }

