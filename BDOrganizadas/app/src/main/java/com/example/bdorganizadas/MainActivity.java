package com.example.bdorganizadas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public DataBaseHelper cliBDh = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cliBDh = new DataBaseHelper(this);
        cliBDh.open(); //Abrimos la base de datos en modo escritura
        //En caso de abrir de forma correcta la base de datos
        if (cliBDh != null) {
            // Introducimos 3 clientes de ejemplo
            for (int cont = 1; cont <= 3; cont++) {
                //Creamos los datos
                int codigo = cont;
                String nombre = "cli" + cont;
                String telefono = cont + "XXXXXXX";
                //Introducimos los datos en la tabla Clientes
                cliBDh.insertItem(codigo, nombre, telefono);
            }

            final Button button = findViewById(R.id.button_id);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Cursor cursor = cliBDh.getItems();
                    TextView txt = findViewById(R.id.texto);
                    String devuelto ="";

                    while(cursor.moveToNext()) {
                        int index;

                        index = cursor.getColumnIndexOrThrow("NOMBRE");
                        String nom = cursor.getString(index);

                        index = cursor.getColumnIndexOrThrow("TELEFONO");
                        String tel = cursor.getString(index);

                        index = cursor.getColumnIndexOrThrow("CODIGO");
                        int cod = cursor.getInt(index);

                        devuelto = nom + tel + cod;


                    }

                    txt.setText(devuelto);
                    cliBDh.close();
                }
            });
        }
    }

}
