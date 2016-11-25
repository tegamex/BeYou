package com.example.frz.beyou;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kevin on 11/5/16.
 */

public class LoadFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_load, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.zoom_in,R.anim.zoom_out)
                        .replace(R.id.fragment,new HomeFragment()).commit();
            }
        },2000);
    }
}
