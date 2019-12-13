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
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static Director[] directores = new Director[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] pelisChristopher = new String[2];
        pelisChristopher[0] = "Interestellar";
        pelisChristopher[1] = "Origen";

        String[] pelisHermanosRusso = new String[2];
        pelisHermanosRusso[0] = "Infinity War";
        pelisHermanosRusso[1] = "End Game";

        directores[0] = new Director("Christopher Nolan", pelisChristopher);
        directores[1] = new Director("Hermanos Russo", pelisHermanosRusso);

        AdaptadorDirectores adaptador = new AdaptadorDirectores(this);

        ListView lview = (ListView) findViewById(R.id.listView);
        try {

            lview.setAdapter(adaptador);
            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                    Director director = directores[position];
                    Intent miIntent= new Intent(MainActivity.this, ListaPeliculas.class);
                    Bundle miBundle=new Bundle();
                    miBundle.putSerializable("CLAVEdirector", director);
                    miIntent.putExtras(miBundle);
                    startActivity(miIntent);
                }
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

    class AdaptadorDirectores extends ArrayAdapter {

        Activity context;

        AdaptadorDirectores(Activity context){
            super(context, R.layout.listitem_director, directores);
            this.context = context;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_director, null);

            TextView labelNombre = (TextView) item.findViewById(R.id.nombre);
            labelNombre.setText(directores[i].getNombre());

            return (item);
        }
    }
}