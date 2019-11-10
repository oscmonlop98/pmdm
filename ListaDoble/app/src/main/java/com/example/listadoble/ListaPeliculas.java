package com.example.listadoble;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListaPeliculas extends AppCompatActivity {

    public static Director director;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_peliculas);

        TextView nombreDirector= (TextView) findViewById(R.id.nombreDirector);
        director =(Director)getIntent().getSerializableExtra("CLAVEdirector");
        nombreDirector.setText("Películas de " + director.getNombre());

        AdaptadorPeliculas adaptador = new AdaptadorPeliculas(this);

        ListView lview = (ListView) findViewById(R.id.lista);
        try {

            lview.setAdapter(adaptador);
            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                }
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        final Button miBoton = (Button) findViewById(R.id.miBtn);

        miBoton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                Intent miIntent= new Intent(ListaPeliculas.this, MainActivity.class);
                startActivity(miIntent);
            }
        });

    }

    class AdaptadorPeliculas extends ArrayAdapter {

        Activity context;

        AdaptadorPeliculas(Activity context){
            super(context, R.layout.listitem_peliculas, director.getPeliculas());
            this.context = context;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_peliculas, null);

            TextView labelNombre = (TextView) item.findViewById(R.id.nombrePelicula);
            labelNombre.setText(director.getPeliculas()[i]);
            return (item);
        }
    }
}