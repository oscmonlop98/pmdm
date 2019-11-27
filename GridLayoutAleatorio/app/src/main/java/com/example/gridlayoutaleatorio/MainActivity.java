package com.example.gridlayoutaleatorio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import static com.example.gridlayoutaleatorio.RandomUtils.randomInt;

public class MainActivity extends AppCompatActivity {

    static Integer [] imgDigits = new Integer[]{R.drawable.barco, R.drawable.bici, R.drawable.coche};

    GridLayout miLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miLayout = (GridLayout)findViewById(R.id.vistaImagenes);

        int count = miLayout.getChildCount();

        for(int i = 0 ; i < count-1 ; i++){
            final ImageView imagen = (ImageView) miLayout.getChildAt(i);
            final int randomImg = RandomUtils.randomElement(imgDigits);
            imagen.setImageResource(randomImg);

            miLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView ultimaImagen = (ImageView) miLayout.getChildAt(miLayout.getChildCount()-1);
                    ultimaImagen.setImageResource(randomImg);

                }
            });
        }



    }
}
