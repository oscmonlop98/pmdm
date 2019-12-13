package com.example.fragmentobasico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    public CheckBox miChBx;
    public View miFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miFrag = (View)findViewById(R.id.miFrg);
        miChBx = (CheckBox) findViewById(R.id.aparece);

        miChBx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (miChBx.isChecked()) {
                    miFrag.setVisibility(View.VISIBLE);
                } else {
                    miFrag.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
