package com.example.examenoscar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityFactura extends AppCompatActivity {

    protected TextView precio;
    protected Main2Activity prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        precio= (TextView) findViewById(R.id.campoPeso);

        prueba=(Main2Activity) getIntent().getSerializableExtra("CLAVEpre");
        prueba.toString();
        precio.setText("Precio: "+ prueba);
    }
}

