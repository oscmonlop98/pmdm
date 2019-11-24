package com.example.examencorregido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;

public class Dibujo extends AppCompatActivity {

    private BitmapDrawable logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }

    class MiDibujo extends View {
        public MiDibujo(Context c) {
            super(c);
            Resources res = c.getResources();
            logo = (BitmapDrawable)res.getDrawable(R.drawable.dibujo);
            logo.setBounds(new Rect(60,60,600,500));
        }

        protected  void onDraw(Canvas lienzo) {

            Paint pincel = new Paint();
            pincel.setColor(Color.GREEN);
            pincel.setStrokeWidth(2);
            pincel.setStyle(Paint.Style.FILL);
            pincel.setTextSize(60);
            lienzo.drawText("Transporte ecológico",100,800,pincel);
            logo.draw(lienzo);
        }
    }
}
