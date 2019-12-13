package com.example.fragmentosdinamicos;


import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    int mNum;
    private int mParam1;

    // Mantenemos el número para usarlo en cualquier momento.
    static SimpleFragment newInstance(int number, int param1) {
        SimpleFragment f = new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt("num", number);
        args.putInt(ARG_PARAM1, param1);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v  = null;
        View tv;
        // Dependiendo de si es par o impar mostramos distintos layouts
        if (mNum % 2 == 0){
            v = inflater.inflate(R.layout.fragment_simple, container, false);
            tv = v.findViewById(R.id.text);
        }
        else{
            v = inflater.inflate(R.layout.fragment_simple2 , container, false);
            tv = v.findViewById(R.id.text2);
            ImageView miFoto = (ImageView) v.findViewById(R.id.image);
            miFoto.setImageResource(mParam1);

        }

        ((TextView)tv).setText("Fragmento numero #" + mNum);
        return v;
    }


}