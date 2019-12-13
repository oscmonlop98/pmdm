package com.example.fragmentosdinamicos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int dibujos [] = {R.drawable.agujero, R.drawable.agujero2, R.drawable.agujero3};
    int mStackPosition = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botón para añadir fragmentos
        Button button = (Button)findViewById(R.id.newFragment);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addFragment();
            }
        });

        //Añadir el primer fragmento
        if (savedInstanceState == null) {
            Fragment newFragment = SimpleFragment.newInstance(mStackPosition, dibujos[0]);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.fragmentShow, newFragment).commit();
        } else {
            mStackPosition = savedInstanceState.getInt("position");
        }
    }

    void addFragment() {
        mStackPosition++;
        Random r = new Random();
        // Instanciamos nuevo Fragmento
        Fragment newFragment = SimpleFragment.newInstance(mStackPosition, dibujos[r.nextInt(dibujos.length)]);

        // Se añade el Fragmento a la actividad
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentShow, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        // Añadimos la transacciónn a la pila
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", mStackPosition);
    }

}