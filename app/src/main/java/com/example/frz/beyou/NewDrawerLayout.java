package com.example.frz.beyou;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;

public class NewDrawerLayout extends DrawerLayout {

    public NewDrawerLayout(Context context) {
        super(context);
    }

    public NewDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NewDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(heightMeasureSpec), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}