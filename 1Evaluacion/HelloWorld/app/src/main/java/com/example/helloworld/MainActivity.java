package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int COD_RESPUESTA=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto = (EditText) findViewById(R.id.editText);
        final Button button1 = (Button) findViewById(R.id.button1);
        //final TextView saludo = (TextView) findViewById(R.id.miLbl);

        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                String mensajePaso = "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);

                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }

        });
    }
}