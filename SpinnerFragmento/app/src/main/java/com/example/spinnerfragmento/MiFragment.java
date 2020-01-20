package com.example.spinnerfragmento;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;



public class MiFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4="param4";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private int mParam4;

    private OnFragmentInteractionListener mListener;

    public MiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @param param3 Parameter 3.
     * @param param4 Parameter 4.
     *
     * @return A new instance of fragment Fragmentper.
     */
    // TODO: Rename and change types and number of parameters
    public static MiFragment newInstance(String param1, String param2,String param3,int param4) {
        MiFragment fragment = new MiFragment();

        Bundle args =  new Bundle();
        Persona p = (Persona) args.getSerializable("datos");

        args.putString(ARG_PARAM1, p.getNombre());
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3= getArguments().getString(ARG_PARAM3);
            mParam4=getArguments().getInt(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_mi, container, false);

        TextView textnombre=(TextView)v.findViewById(R.id.nombrePersona);
        textnombre.setText("Nombre"+ mParam1 + "\n");

//        TextView textapellido=(TextView)v.findViewById(R.id.apellidosPersona);
//        textapellido.setText("Apellido"+mParam1 + "\n");
//
//        TextView textEdad=(TextView)v.findViewById(R.id.edadPersona);
//        textEdad.setText("Edad"+mParam1 + "\n");

//        ImageView foto=(ImageView)v.findViewById(R.id.fotoPersona);
//        foto.setImageResource(mParam4);

        return v;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

