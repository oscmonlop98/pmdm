package com.example.spinnerpersona;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Spinner spinnerPersona;
    private Persona[] personas = new Persona[]{
            new Persona("Pepe", "Moreno", 16, R.drawable.pepe),
            new Persona("Oscar", "Moreno", 35, R.drawable.pepe)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerPersona = (Spinner)findViewById(R.id.spPersona);
        AdaptadorPersonas adaptadorPersonas = new AdaptadorPersonas(this);
        spinnerPersona.setAdapter(adaptadorPersonas);

        spinnerPersona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "";
                mensaje = "Item clicked => " + personas[position];
                showToast(mensaje);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    class AdaptadorPersonas extends ArrayAdapter {

        Activity context;

        AdaptadorPersonas(Activity context){
            super(context, R.layout.activity_persona, personas);
            this.context = context;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position,convertView,parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_persona, null);

            TextView labelNombre = (TextView) item.findViewById(R.id.nombrePersona);
            labelNombre.setText(personas[i].getNombre());

            TextView labelApellidos = (TextView) item.findViewById(R.id.apellidosPersona);
            labelApellidos.setText(personas[i].getApellido());

            TextView labelEdad = (TextView) item.findViewById(R.id.edadPersona);
            labelEdad.setText(String.valueOf(personas[i].getEdad()));

            ImageView imagen = (ImageView) item.findViewById(R.id.fotoPersona);
            imagen.setImageResource(personas[i].getFoto());

            return (item);
        }
    }

    public void showToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }
}