package com.example.fragmentoboton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Button miBtn;
    public Fragment miFrag;
    int mStackPosition = 1;

    int dibujos [] = {R.drawable.harry, R.drawable.endgame, R.drawable.starwars};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miBtn = (Button)findViewById(R.id.buttonCambia);
        miBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });

        if (savedInstanceState==null) {

            Fragment miFragment = MiFragment.newInstance(dibujos[0]);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.addToBackStack(null);
            ft.commit();
        } else {
            mStackPosition = savedInstanceState.getInt("position");
        }
    }

    public void addFragment() {
        Fragment miFragment;
        Random r = new Random();

        miFragment = MiFragment.newInstance(dibujos[r.nextInt(dibujos.length)]);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.miFrg, miFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onSaveInstanceState (@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("position", mStackPosition);
    }
}
