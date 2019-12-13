package com.example.ciclovida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private RadioButton rbtGreen, rbtBlue, rbtRed;
    private TextView tvColor;
    private Button btnHobby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rbtGreen = findViewById(R.id.rbtGreen);
        rbtBlue = findViewById(R.id.rbtBlue);
        rbtRed = findViewById(R.id.rbtRed);
        tvColor = findViewById(R.id.tvColor);
        btnHobby = findViewById(R.id.btnHobby);

        rbtGreen.setOnCheckedChangeListener(this);
        rbtBlue.setOnCheckedChangeListener(this);
        rbtRed.setOnCheckedChangeListener(this);

        btnHobby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(miIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this,"onPause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.rbtGreen:
                tvColor.setBackgroundColor(Color.GREEN);
                break;
            case R.id.rbtBlue:
                tvColor.setBackgroundColor(Color.BLUE);
                break;
            case R.id.rbtRed:
                tvColor.setBackgroundColor(Color.RED);
                break;
        }
    }
}