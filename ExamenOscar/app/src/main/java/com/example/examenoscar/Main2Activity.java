package com.example.examenoscar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    public Spinner spinnerAlquiler;
    private EditText diasAlquiler;
    private RadioButton seguro;
    private CheckBox casco, gps, extras;
    private TextView precioTotal;
    private Button btnFinal;
    private Button btnFinal2;
    double precioResultado = 0;
    double resultadoAMostrar = 0;
    private double resultadoFinal = 0;
    private TextView lblMensaje;

    /* LOGOS DE LA PRIMERA  PANTALLA */
    int tiposMedio[] = {R.drawable.patinete, R.drawable.bicis, R.drawable.coches};

    /* Contenido de los spinner segun los medios elegidos */
    private MedioTransporte[] electricos = new MedioTransporte[]{
            new MedioTransporte("skate", "Roxi", "12", R.drawable.skate),
            new MedioTransporte("patinete", "Roxi", "15", R.drawable.patinete),
            new MedioTransporte("monociclo", "Oneil", "18", R.drawable.monociclo1)};

//    private MedioTransporte[] bicis = new MedioTransporte[]{
//            new MedioTransporte("Paseo", "Orbea", "15"),
//            new MedioTransporte("Ciudad", "Cube", "20"),
//            new MedioTransporte("Montaña", "Bike", "25")};
//
//    private MedioTransporte[] coches = new MedioTransporte[]{
//            new MedioTransporte("Megane", "Renault", "60"),
//            new MedioTransporte("Leon", "Seat", "70"),
//            new MedioTransporte("Fiesta", "Ford", "75")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        spinnerAlquiler = (Spinner)findViewById(R.id.spAlquiler);
        diasAlquiler = (EditText)findViewById(R.id.editDias);
        seguro = (RadioButton) findViewById(R.id.conSeguro);
        casco = (CheckBox)findViewById(R.id.casco);
        gps = (CheckBox)findViewById(R.id.gps);
        extras = (CheckBox)findViewById(R.id.extras);
        precioTotal = (TextView)findViewById(R.id.preTotal);


        AdaptadorAlquiler adaptadorAlquiler = new AdaptadorAlquiler(this);
        spinnerAlquiler.setAdapter(adaptadorAlquiler);


        spinnerAlquiler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                precioResultado = Integer.parseInt(electricos[position].getPrecio());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnFinal2 = (Button)findViewById(R.id.btnCalcular);
        btnFinal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultadoAMostrar = getSeguro();

                precioTotal.setText("Precio final: " + resultadoAMostrar);
                System.out.println(resultadoFinal);
            }
        });

        btnFinal = (Button)findViewById(R.id.btnFactura);
        btnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                precioTotal.setText(getSeguro());
//                resultadoFinal = precioTotal.toString();

                Intent miIntent = new Intent(Main2Activity.this, ActivityFactura.class);
                Bundle miBundle = new Bundle();

                miBundle.putSerializable("CLAVEpre", resultadoFinal);

                miIntent.putExtras(miBundle);
                startActivity(miIntent);

            }

        });
    }

    class AdaptadorAlquiler extends ArrayAdapter {

        Activity context;

        AdaptadorAlquiler(Activity context){
            super(context, R.layout.activity_medio_transporte, electricos);
            this.context = context;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position,convertView,parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_medio_transporte, null);

            TextView labelModelo = (TextView) item.findViewById(R.id.modelo);
            labelModelo.setText(electricos[i].getModelo());

            TextView labelTipo = (TextView) item.findViewById(R.id.tipo);
            labelTipo.setText(electricos[i].getTipo());

            TextView labelPrecio = (TextView) item.findViewById(R.id.precio);
            labelPrecio.setText(String.valueOf(electricos[i].getPrecio()));

            ImageView imagen = (ImageView) item.findViewById(R.id.foto);
            imagen.setImageResource(electricos[i].getLogo());

            return (item);
        }
    }


    public Double getSeguro() {
        if (seguro.isChecked()) {
            double a = getExtras();
            a = a + (80 *0.2);
            resultadoFinal = a;
        }
        return resultadoFinal;

    }

    public double getDiasFinal() {
        int diasFinal = Integer.parseInt(diasAlquiler.getText().toString());
        precioResultado = precioResultado*diasFinal;
        return precioResultado;
    }

    public double getExtras() {
        double a = getDiasFinal();
        if (casco.isChecked()) {
            precioResultado = a + 50;
        }
        if (gps.isChecked()) {
            if (casco.isChecked()) {
                precioResultado = precioResultado + 50;
            }
            precioResultado = a + 50;
        }
        if (extras.isChecked()) {
            if (gps.isChecked()) {
                if (casco.isChecked()) {
                    precioResultado = precioResultado + 50;
                }
                precioResultado = precioResultado + 50;
            }
            precioResultado = a + 50;
        }
        //resultadoFinal = Integer.toString(precioResultado);
        return precioResultado;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx_etiqueta, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                lblMensaje.setText("Opcion 2 pulsada!");
                return true;
            case R.id.MnuOpc2:
                lblMensaje.setText("Opcion 2 pulsada!");
                return true;
            case R.id.MnuOpc3:
                lblMensaje.setText("Opcion 3 pulsada!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    public void showToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }
}
