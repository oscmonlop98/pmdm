package com.example.baseinicial;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class EjemploBaseDatos extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBClientes", null, 1);
        SQLiteDatabase bd = cliBDh.getWritableDatabase();

        if (bd != null) {
            for (int cont = 1; cont <= 3; cont++) {
                int codigo = cont;
                String nombre = "Cli" + cont;
                String telefono = cont + "XXXXXX";


                bd.execSQL("INSERT INTO Clientes (codigo, nombre, telefono)" + "VALUES (" + codigo + ", '" + nombre + "', '" + telefono + "')");
            }

            String[] campos = new String[] {"nombre", "telefono"};
            String[] args = new String[] {"cli"};
            Cursor c = bd.rawQuery("SELECT nombre, telefono FROM Clientes WHERE nombre=? ", args);

            if (c.moveToFirst()) {
                do {
                    String nombreCli = c.getString(0);
                    String telefonoCli = c.getString(1);
                } while (c.moveToNext());
            }

            bd.close();
        }


    }
}