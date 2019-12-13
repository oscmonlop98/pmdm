package com.example.ejerciciorecopilatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.IntentService;
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

public class MainActivity extends AppCompatActivity {

    public Spinner spinnerPedidos;
    private Button buttonCalcular;
    private EditText peso;
    private RadioButton urgente;
    private CheckBox regalo, tarjeta;
    private Pedido pedido1;
    private TextView lblMensaje;


    private final String[] days = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerPedidos = (Spinner)findViewById(R.id.spPedidos);
        peso = (EditText)findViewById(R.id.editPeso);

//        lblMensaje = (TextView)findViewById(R.id.lblMensaje);
//        registerForContextMenu(lblMensaje);

        AdaptadorPedidos adaptadorPedidos = new AdaptadorPedidos(this);
//        spinnerPedidos.setAdapter(adaptadorPedidos);
        spinnerPedidos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, days));

        spinnerPedidos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "";
                mensaje = "Item clicked => ";
                showToast(mensaje);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonCalcular = findViewById(R.id.btnCalcular);
        buttonCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String elPeso = peso.getText().toString();
                pedido1 = new Pedido(elPeso);

                Intent miIntent = new Intent(MainActivity.this, PedidoActivity.class);
                Bundle miBundle = new Bundle();

                miBundle.putSerializable("CLAVEped", pedido1);

                miIntent.putExtras(miBundle);
                startActivity(miIntent);

            }
        });
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
            case R.id.view_monigote:
                Intent intent = new Intent(this, Monigote.class);
                startActivity(intent);
            case R.id.MnuOpc2:
                lblMensaje.setText("Opcion 2 pulsada!");
                return true;
            case R.id.MnuOpc3:
                lblMensaje.setText("Opcion 3 pulsada!");
                return true;
            case R.id. SubMnuOpc1:
                lblMensaje.setText("Submenu: Opcion 1!");
                return true;
            case R.id. SubMnuOpc2:
                lblMensaje.setText ("Submenu: Opcion 2!"); ;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    class AdaptadorPedidos extends ArrayAdapter {

        Activity context;

        AdaptadorPedidos(Activity context){
            super(context, R.layout.activity_spinner);
            this.context = context;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position,convertView,parent);
            return vistaDesplegada;
        }

//        public View getView(int i, View convertView, ViewGroup parent){
//            LayoutInflater inflater = context.getLayoutInflater();
//            View item = inflater.inflate(R.layout.activity_pedido, null);
//
//
//            TextView labelApellidos = (TextView) item.findViewById(R.id.apellidosPersona);
//            labelApellidos.setText(personas[i].getApellido());
//
//            TextView labelEdad = (TextView) item.findViewById(R.id.edadPersona);
//            labelEdad.setText(String.valueOf(personas[i].getEdad()));
//
//            ImageView imagen = (ImageView) item.findViewById(R.id.fotoPersona);
//            imagen.setImageResource(personas[i].getFoto());
//
//            return (item);
//        }
    }

    public void showToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }
}
