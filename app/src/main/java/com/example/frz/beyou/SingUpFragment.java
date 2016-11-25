package com.example.frz.beyou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by kevin on 11/5/16.
 */

public class SingUpFragment extends Fragment implements View.OnClickListener {
    Button register;
    @Override
    public void onClick(View v) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter,R.anim.exit)
                .replace(R.id.fragment,new ProfileFragment()).commit();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_singup, container, false);
        register=(Button)v.findViewById(R.id.register);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        register.setOnClickListener(this);
    }
}
