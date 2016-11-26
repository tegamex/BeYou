package com.example.frz.beyou;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by kevin on 11/26/16.
 */

public class ProfileFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_profile, container, false);
        v.findViewById(R.id.afiliationid).setOnClickListener(this);
        return v;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.afiliationid:
                Log.i("mensaje","ggwp");
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.zoom_in,R.anim.zoom_out)
                        .add(R.id.fragment,new AfiliationFragment()).addToBackStack(null).commit();
                Log.i("mensaje","ggwp2");

                break;
        }
    }
}
