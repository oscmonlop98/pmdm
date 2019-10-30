package com.example.plantillainicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla2 extends MainActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        final TextView otroSaludo= (TextView)findViewById(R.id.textView);
        final Button buttonAtras = (Button) findViewById(R.id.buttonAtras);
        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));


        buttonAtras.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent miIntent = new Intent(Pantalla2.this, MainActivity.class);
                startActivity(miIntent);
            }
        });
    }
}