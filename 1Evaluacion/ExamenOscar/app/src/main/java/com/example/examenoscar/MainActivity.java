package com.example.examenoscar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonContinuar;
    private ImageView imagen1;
    private MedioTransporte[] seleccionado;

    /* LOGOS DE LA PRIMERA  PANTALLA */
    int tiposMedio[] = {R.drawable.patinete, R.drawable.bicis, R.drawable.coches};

    /* Contenido de los spinner segun los medios elegidos */
    private MedioTransporte[] electricos = new MedioTransporte[]{
            new MedioTransporte("skate", "Roxi", "12", R.drawable.skate),
            new MedioTransporte("patinete", "Roxi", "15", R.drawable.patinete),
            new MedioTransporte("monociclo", "Oneil", "18", R.drawable.monociclo1)};

    private MedioTransporte[] bicis = new MedioTransporte[]{
            new MedioTransporte("Paseo", "Orbea", "15", R.drawable.bici1),
            new MedioTransporte("Ciudad", "Cube", "20", R.drawable.bici2),
            new MedioTransporte("Montaña", "Bike", "25", R.drawable.bici3)};

    private MedioTransporte[] coches = new MedioTransporte[]{
            new MedioTransporte("Megane", "Renault", "60", R.drawable.megan1),
            new MedioTransporte("Leon", "Seat", "70", R.drawable.leon3),
            new MedioTransporte("Fiesta", "Ford", "75", R.drawable.fiesta2)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen1 = (ImageView) findViewById(R.id.img_11);
        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonContinuar = findViewById(R.id.btn);
        buttonContinuar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle miBundle = new Bundle();

                startActivity(miIntent);

            }
        });
    }
}
