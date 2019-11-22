package com.example.examencorregido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static int imgDigits[] = {R.id.img_11, R.id.img_12, R.id.img_13};
    private Button buttonContinuar;
    ImageView imagenes[];
    ImageView imgElegida;
    TextView textoElegido;
    int op = 0;
    private MedioTransporte[] seleccionado;

    /* LOGOS DE LA PRIMERA  PANTALLA */
    int tiposMedio[] = {R.drawable.patinete, R.drawable.bicis, R.drawable.coches};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoElegido = (TextView) findViewById(R.id.txtResul);
        imgElegida = (ImageView) findViewById(R.id.imgResul);

        imagenes = new ImageView[3];
        for (int i = 0; i < 3; i++) {
            imagenes[i] = (ImageView)findViewById(imgDigits[i]);
        }

        for (int i = 0; i < 3; i++) {
            imagenes[i].setOnClickListener(new MiEleccion());
        }

        buttonContinuar = (Button)findViewById(R.id.btn);
        buttonContinuar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle miBundle = new Bundle();

                miBundle.putInt("opcion", op);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });
    }

    class MiEleccion implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ImageView iv = (ImageView) v;
            String opTxt="ALQUILER DE ";

            switch (iv.getId()) {
                case R.id.img_11:
                    op=1;
                    opTxt+="PATINENETES ELECTRICOS";
                    break;
                case R.id.img_12:
                    op=2;
                    opTxt+="BICICLETAS";
                    break;
                case R.id.img_13:
                    op=3;
                    opTxt+="COCHES";
                    break;
            }
            imgElegida.setImageDrawable(iv.getDrawable());
            textoElegido.setText(opTxt);
        }
    }
}