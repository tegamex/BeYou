package com.example.frz.beyou;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gerson on 03/12/16.
 */

public class PublishFragment extends NewFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_publish_picture, container, false);
        return v;
    }
}
