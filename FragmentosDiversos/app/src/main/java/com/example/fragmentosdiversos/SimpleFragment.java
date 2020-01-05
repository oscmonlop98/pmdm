package com.example.fragmentosdiversos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimpleFragment extends Fragment {
    int mNum;
    static SimpleFragment newInstance(int number) {
        SimpleFragment f = new SimpleFragment();
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = null;
        if (mNum % 2 == 0) {
            v = inflater.inflate(R.layout.layout1, container, false);
            View tv = v.findViewById(R.id.text);
            ((TextView)tv).setText("Fragmento número #" + mNum);
        } else {
            v = inflater.inflate(R.layout.layout2, container, false);
            View tv = v.findViewById(R.id.text);
            ((TextView)tv).setText("Fragmento número #" + mNum);
        }
        return v;
    }
}
