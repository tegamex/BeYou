package com.example.frz.beyou;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kevin on 11/26/16.
 */

public class AfiliationFragment extends DialogFragment implements View.OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_afiliation_card, container, false);
        //v.findViewById(R.id.button).setOnClickListener(this);
        v.findViewById(R.id.validar).setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.validar:
                dismiss();
                break;
        }
    }
}
