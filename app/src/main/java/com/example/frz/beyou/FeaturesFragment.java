package com.example.frz.beyou;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by gerson on 29/10/16.
 */

public class FeaturesFragment extends NewFragment implements View.OnClickListener{
    Button contin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_features, container, false);
        contin=(Button)v.findViewById(R.id.contin);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter,R.anim.exit)
                .replace(R.id.fragment,new MuralFragment()).commit();
    }
}