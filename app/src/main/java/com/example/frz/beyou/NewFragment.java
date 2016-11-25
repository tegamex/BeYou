package com.example.frz.beyou;

import android.support.v4.app.Fragment;
import android.view.animation.Animation;

/**
 * Created by proyectoredneuronal on 24/10/16.
 */
public class NewFragment extends Fragment {
    public static boolean sDisableFragmentAnimations = false;
    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (sDisableFragmentAnimations) {
            Animation a = new Animation() {};
            a.setDuration(0);
            return a;
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
