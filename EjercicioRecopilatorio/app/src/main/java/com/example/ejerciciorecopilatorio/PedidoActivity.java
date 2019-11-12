package com.example.ejerciciorecopilatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PedidoActivity extends AppCompatActivity {

    protected TextView miPeso;
    protected Pedido pedidoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        miPeso= (TextView) findViewById(R.id.campoPeso);

        pedidoo=(Pedido) getIntent().getSerializableExtra("CLAVEped");

        miPeso.setText("Peso: "+ pedidoo.getPeso());
    }
}
