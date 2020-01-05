package com.example.fragmentosdiversos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int mStackPosition = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.newFragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });
        if (savedInstanceState == null) {
            Fragment newFragment = SimpleFragment.newInstance(mStackPosition);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.fragmentShow, newFragment).commit();
        } else {
            mStackPosition = savedInstanceState.getInt("position");
        }
        Button buttonDialogF = (Button)findViewById(R.id.showDialogF);
        Button buttonDialog = (Button)findViewById(R.id.showDialog);
        buttonDialogF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {showDialogF();}
        });
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {showDialog();}
        });
    }

    void addFragment() {
        mStackPosition++;
        Fragment newFragment = SimpleFragment.newInstance(mStackPosition);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentShow, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);// poneos la transacion a la pila
        ft.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", mStackPosition);
    }

    void showDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Selecciona accion a realizar")
                .setPositiveButton("Nuevo",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                addFragment();
                            }
                        }
                )
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // no hacer nada
                            }
                        }
                )
                .setNeutralButton("Atrás",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                getFragmentManager().popBackStack();
                            }
                        }
                )
                .create().show();
    }
    void showDialogF() {
        DialogFragment newFragment = MyDialogFragment.newInstance(
                "Cadena de ejemplo como parámetro");
        newFragment.show(getFragmentManager(), "dialog");
    }
}
