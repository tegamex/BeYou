package com.example.frz.beyou;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gerson on 29/10/16.
 */

public class ReservaFragment extends NewFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reserva, container, false);
        return v;
    }
}