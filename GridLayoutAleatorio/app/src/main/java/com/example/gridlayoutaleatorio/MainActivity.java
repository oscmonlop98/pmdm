package com.example.gridlayoutaleatorio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import static com.example.gridlayoutaleatorio.RandomUtils.randomInt;

public class MainActivity extends AppCompatActivity {

    static int imgDigits[] = {R.id.barcos, R.id.bicis, R.id.coches};

    ImageView imagenes[];
    ImageView imgElegida;


    private int numero = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgElegida = (ImageView)findViewById(R.id.imagenElegida);

        randomInt(numero);

        imagenes  = new ImageView[3];
        for (int i = 0; i < 3; i++) {
            imagenes[numero] = (ImageView)findViewById(imgDigits[numero]);
        }

    }
}
