package com.example.miprimerdia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    MediaPlayer miMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miMusica= MediaPlayer.create(getApplicationContext(),R.raw.desigual);

        final ToggleButton btnBoton2= (ToggleButton)findViewById(R.id.miTogBtn);
        final TextView miTexto = (TextView) findViewById(R.id.mitTxt);
        final ImageView milogo = (ImageView) findViewById(R.id.logoDesigual);
        final Button miBoton = (Button) findViewById(R.id.miBtn);

        btnBoton2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0){
                if(btnBoton2.isChecked()) {
                    miMusica.start();
                }
                    else
                        miMusica.stop();
            }
        });


//        miBoton.setOnClickListener((v) {
//            miTexto.setText("CANCIÓN:" + "registrado por: Desigual");
//            milogo.setImageResource(R.drawable.marcadesigual);
//        });

    }
}
