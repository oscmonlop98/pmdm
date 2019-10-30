package com.example.eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context ctx = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctx = this;

        Button button1 = (Button)this.findViewById(R.id.button1);

        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(ctx, "Pulsado botón Tres", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
