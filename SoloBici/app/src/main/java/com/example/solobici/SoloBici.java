package com.example.solobici;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SoloBici extends AppCompatActivity {

    private Button bJuego;
    private Button bPreferencias;
    private Button bAcercaDe;
    private Button bSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bJuego = (Button)findViewById(R.id.boton01);
        bJuego.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                lanzarJuego();
            }
        });

        bAcercaDe = (Button)findViewById(R.id.boton03);
        bAcercaDe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                lanzarJuego();
            }
        });

    }
}
