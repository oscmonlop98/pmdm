package com.example.eventos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;


public class MiButton extends androidx.appcompat.widget.AppCompatButton implements View.OnClickListener {
    Context context;

    public MiButton(Context context) {
        super(context);
        this.context =context;
        this.setOnClickListener(this);
    }

    public MiButton(Context context, AttributeSet attr){
        super(context,attr);
        this.context =context;
        this.setOnClickListener(this);
    }

    public MiButton(Context context, AttributeSet attr, int defaultStyles){

        super(context,attr,defaultStyles);
        this.context =context;
        this.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Toast.makeText(context, "Boton 3 desde clase externa", Toast.LENGTH_SHORT).show();
    }

}
