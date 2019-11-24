package com.example.examencorregido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityFactura extends AppCompatActivity {

    Factura factura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        factura = (Factura)getIntent().getSerializableExtra("factura");

        ImageView imagen = (ImageView)findViewById(R.id.imagen);
        imagen.setImageResource(factura.getMedio()[0].getImagen());

        TextView texto = (TextView)findViewById(R.id.textoResultado);
        String textoFinal = "Modelo: " + factura.getMedio()[0].getModelo() + "\n"+
                "Precio por días: " + factura.getMedio()[0].getPrecio() + "€\n"+
                "Extras: " + factura.getExtras() + "€\n"+
                "Días: " + factura.getDias()+"\n";
        if (factura.getSeguro())
            textoFinal += "Seguro: Con Seguro COMPLETO\n";
        else
            textoFinal += "Seguro: Sin Seguro\n";
        texto.setText(textoFinal);

        TextView textTotal = (TextView)findViewById(R.id.textoTotal);
        textTotal.setText("Coste Total: " + factura.calcularTotal() + "€");
    }
}
