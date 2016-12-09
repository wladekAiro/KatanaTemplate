package com.example.wladek.katanatemplate.utils;

import android.graphics.drawable.Drawable;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class TouchEffect implements OnTouchListener {
    public boolean onTouch(View v, MotionEvent event) {
        Drawable d;
        if (event.getAction() == 0) {
            d = v.getBackground();
            d.mutate();
            d.setAlpha(150);
            v.setBackgroundDrawable(d);
        } else if (event.getAction() == 1 || event.getAction() == 3) {
            d = v.getBackground();
            d.setAlpha(MotionEventCompat.ACTION_MASK);
            v.setBackgroundDrawable(d);
        }
        return false;
    }
}
