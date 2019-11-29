package com.example.solobici;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class Grafico {
    private Drawable drawable;
    private double posX, posY;
    private double incX, incY;
    private int angulo, rotacion;
    private int ancho, alto;
    private int radioColision;

    private View view;
    public static final int MAX_VELOCIDAD = 20;

    public Grafico(View view, Drawable drawable) {
        this.view = view;
        this.drawable = drawable;
        ancho = drawable.getIntrinsicWidth();
        alto = drawable.getIntrinsicHeight();
        radioColision = (alto + ancho) / 4;
    }

    public void dibujaGrafico(Canvas canvas) {
        canvas.save();
        int x = (int) (posX + ancho / 2);
        int y = (int) (posY + alto / 2);
        canvas.rotate((float) angulo, (float) x, (float) y);
        drawable.setBounds((int) posX, (int) posY, (int) posX + ancho, (int) posY + alto);

        drawable.draw(canvas);
        canvas.restore();

        int rInval = (int) distanciaE(0,0, ancho, alto) / 2 + MAX_VELOCIDAD;
        view.invalidate(x - rInval, y - rInval, x + rInval, y + rInval);
    }

    public void incrementaPos(){
        posX += incX;

        if (posX < -ancho / 2) {
            posX = view.getWidth() - ancho / 2;
        }

        if (posX > view.getWidth() - ancho / 2) {
            posX = - ancho / 2;
        }

        posY += incY;
        if (posY < - alto / 2) {
            posY = view.getHeight() - alto / 2;
        }
        if (posY > view.getHeight() - alto / 2) {
            posY = - alto / 2;
        }
        angulo += rotacion;
    }

    public static double distanciaE(double x, double y, double x2, double y2) {
        return Math.sqrt((x-2) * (x-x2) + (y-y2) * (y-y2));
    }
}
