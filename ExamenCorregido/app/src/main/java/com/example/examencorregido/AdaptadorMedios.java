package com.example.examencorregido;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdaptadorMedios extends ArrayAdapter<MedioTransporte> {
    class Holder {
        TextView medioNombre;
        TextView medioModel;
        TextView medioPrecio;
        ImageView medioImagen;
    }

    private List<MedioTransporte> transportes;

    public AdaptadorMedios(@NonNull Context context, int resource,@NonNull MedioTransporte[] transportes) {
        super(context, resource, transportes);
        this.transportes = Arrays.asList(transportes);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        Holder h;
        if(v == null) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.transport_item, parent, false);
            h = new Holder();
            h.medioNombre = v.findViewById(R.id.itemNombre);
            h.medioModel = v.findViewById(R.id.itemModelo);
            h.medioPrecio = v.findViewById(R.id.itemPrecio);
            h.medioImagen = v.findViewById(R.id.itemImagen);
            v.setTag(h);
        }else
            h = (Holder)v.getTag();
        MedioTransporte vehicle = transportes.get(position);
        h.medioNombre.setText(vehicle.getModelo());
        h.medioModel.setText(vehicle.getMarca());
        h.medioPrecio.setText(vehicle.getPrecio());
        h.medioImagen.setImageResource(vehicle.getImagen());
        return v;
    }
    @Override
    public View getDropDownView(int position,@NonNull View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return transportes.size();
    }
}