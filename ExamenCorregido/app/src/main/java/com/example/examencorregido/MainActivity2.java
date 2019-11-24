package com.example.examencorregido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public Spinner spinnerMedios;
    private int opcion = 0;
    private MedioTransporte[] medioSeleccionado;
    private boolean seguroCompleto;
    private String seguroSeleccionado;
    private float precioTotal;
    private Factura factura;
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
        setContentView(R.layout.activity_main2);

        spinnerMedios = (Spinner)findViewById(R.id.spinnerMedio);
        opcion = (int)getIntent().getSerializableExtra("opcion");

        switch (opcion) {
            case 1:
                medioSeleccionado = electricos;
                break;
            case 2:
                medioSeleccionado = bicis;
                break;
            case 3:
                medioSeleccionado = coches;
                break;
        }

        ArrayAdapter<MedioTransporte> adaptador = new AdaptadorMedios(this, R.layout.transport_item, medioSeleccionado);
        spinnerMedios.setAdapter(adaptador);

        final EditText editDias = (EditText)findViewById(R.id.numDias);

        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.grupoSeguro);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.getCheckedRadioButtonId()==R.id.radioCon) {
                    seguroCompleto = true;
                    seguroSeleccionado = "Con seguro";
                }else if (group.getCheckedRadioButtonId()==R.id.radioSin){
                    seguroCompleto = false;
                    seguroSeleccionado = "Sin seguro";
                }
            }
        });

        final CheckBox casco = (CheckBox)findViewById(R.id.checkCasco);
        final CheckBox gps = (CheckBox)findViewById(R.id.checkGPS);
        final CheckBox extra = (CheckBox)findViewById(R.id.checkExtras);

        final TextView textPrecio = (TextView)findViewById(R.id.labelPrecioTotal);

        Button btnCalcular = (Button)findViewById(R.id.buttonCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                float extras = 0;
                if (casco.isChecked())
                    extras += 50;
                if (extra.isChecked())
                    extras += 50;
                if (gps.isChecked())
                    extras += 50;

                factura = new Factura(medioSeleccionado, Integer.parseInt(editDias.getText().toString()),extras,seguroCompleto);
                precioTotal = factura.calcularTotal();
                textPrecio.setText(precioTotal + "€");
            }

        });

        Button btnFactura = (Button)findViewById(R.id.buttonFactura);
        btnFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity2.this, ActivityFactura.class);
                Bundle miBundle = new Bundle();

                miBundle.putSerializable("factura", factura);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });



    }
}
