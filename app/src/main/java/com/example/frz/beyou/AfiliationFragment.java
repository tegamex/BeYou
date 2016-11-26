package com.example.frz.beyou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kevin on 11/26/16.
 */

public class AfiliationFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_afiliation_card, container, false);
        //v.findViewById(R.id.button).setOnClickListener(this);
        return v;
    }
}
