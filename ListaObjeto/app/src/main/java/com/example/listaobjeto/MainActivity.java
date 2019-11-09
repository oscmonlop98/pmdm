package com.example.listaobjeto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Persona[] personas = new Persona[]{
            new Persona("Pepa", "Salas", 1, R.drawable.pepa),
            new Persona("Oscar", "Moreno", 2, R.drawable.oscar)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorPersonas adaptador = new AdaptadorPersonas(this);
        ListView listaPersonas = (ListView) findViewById(R.id.listaPersonas);

        try {
            listaPersonas.setAdapter(adaptador);


            listaPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                    String mensaje = "Nombre: " + personas[position].getNombre()
                            + "Apellidos: " + personas[position].getApellido();

                    showToast(mensaje);
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    class AdaptadorPersonas extends ArrayAdapter {

        Activity context;

        AdaptadorPersonas(Activity context){
            super(context, R.layout.activity_persona, personas);
            this.context = context;
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