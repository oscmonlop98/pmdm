package com.example.hilosejecucion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText entrada;
    private TextView salidaHilos;
    private TextView salidaAsync;
    private Button botonHilos;
    private Button botonAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrada = (EditText)findViewById(R.id.editText);
        salidaHilos = (TextView)findViewById(R.id.textViewHilos);
        salidaAsync = (TextView)findViewById(R.id.textViewAsync);
        botonHilos = (Button)findViewById(R.id.buttonHilos);
        botonAsync = (Button)findViewById(R.id.buttonAsync);

        botonHilos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOperacionHilos(v);
            }
        });

        botonAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOperacionAsync(v);
            }
        });

    }

    public void calcularOperacionHilos(View view) {
        int n = Integer.parseInt(entrada.getText().toString());
        salidaHilos.append("Ejecución con Hilos: " + n + "! =");
        MiThread thread = new MiThread(n);
        thread.start();
    }

    public void calcularOperacionAsync(View view) {
        int n = Integer.parseInt(entrada.getText().toString());
        salidaAsync.append("Ejecución con Async: " + n + "! =");
        MiTarea tarea = new MiTarea();
        tarea.execute(n);
    }

    public int factorial(int n) {
        int res = 1;
        for (int i = 1; i<=n; i++) {
            res*=i;
            SystemClock.sleep(1500);
        }
        return res;
    }

    class MiThread extends Thread {
        private int n, res;
        public  MiThread(int n) {
            this.n = n;
        }
        public  void run() {
            res=factorial(n);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    salidaHilos.append(res + "\n");
                }
            });
        }
    }

    class MiTarea extends AsyncTask<Integer,Void,Integer> {
        @Override
        protected Integer doInBackground(Integer... n) {
            return  factorial(n[0]);
        }
        @Override
        protected void onPostExecute (Integer res) {
            salidaAsync.append(res + "\n");
        }
    }
}
