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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        // BotÃ³n de aÃ±adir fragments
        Button button = (Button) findViewById(R.id.newFragment);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {addFragment();}
        });
        if (savedInstanceState == null) {
            // aÃ±adir el primer fragment
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
        // Instanciamos nuevo Fragment
        Fragment newFragment = SimpleFragment.newInstance(mStackPosition);
        // Se aÃ±ade el Fragment a la actividad
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
                .setNeutralButton("AtrÃ¡s",
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
                "Cadena de ejemplo como parÃ¡metro");
        newFragment.show(getFragmentManager(), "dialog");
    }
}

public class MyDialogFragment  extends DialogFragment {
    public static MyDialogFragment newInstance(String valor) {
        MyDialogFragment frag = new MyDialogFragment();
   /*
   Bundle bundle = new Bundle();
   bundle("clave", valor);
   frag.setArguments(bundle);
   */
        return frag;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup dlgview = (ViewGroup) inflater.inflate(R.layout.fragment_my_dialog, null);
        // botÃ³n nuevo Fragment
        Button buttonShow = (Button) dlgview.findViewById(R.id.newFrag);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((MainActivity) getActivity()).addFragment();
            }
        });
        // botÃ³n cancelar
        Button buttonCancel = (Button) dlgview.findViewById(R.id.cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dismiss();
            }
        });
        // botÃ³n ir a Fragment anterior
        Button buttonBack = (Button) dlgview.findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        // asignar el dialog a la vista
        return new AlertDialog.Builder(getActivity()).setView(dlgview).create();
    }
}
