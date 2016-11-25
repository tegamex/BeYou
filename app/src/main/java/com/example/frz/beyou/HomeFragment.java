package com.example.frz.beyou;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by proyectoredneuronal on 24/10/16.
 */
public class HomeFragment extends NewFragment implements View.OnClickListener{
    Button login,loginFB,loginGO,register;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        login=(Button)v.findViewById(R.id.login);
        loginFB=(Button)v.findViewById(R.id.logingFB);
        loginGO=(Button)v.findViewById(R.id.loginGO);
        register=(Button)v.findViewById(R.id.register);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        login.setOnClickListener(this);
        loginFB.setOnClickListener(this);
        loginGO.setOnClickListener(this);
        register.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
            case R.id.logingFB:
            case R.id.loginGO:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit)
                        .replace(R.id.fragment,new ProfileFragment()).commit();
                break;
            case R.id.register:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit)
                        .replace(R.id.fragment,new SingUpFragment()).commit();
                break;
        }
    }
}
