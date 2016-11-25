package com.example.frz.beyou;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by proyectoredneuronal on 24/10/16.
 */
public class RegisterFragment extends NewFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_singup, container, false);

        return v;
    }
}
