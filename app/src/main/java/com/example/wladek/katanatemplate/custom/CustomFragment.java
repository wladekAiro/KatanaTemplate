package com.example.wladek.katanatemplate.custom;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;

public class CustomFragment extends Fragment implements OnClickListener {
    public View setTouchNClick(View v) {
        v.setOnClickListener(this);
        v.setOnTouchListener(CustomActivity.TOUCH);
        return v;
    }

    public void onClick(View v) {
    }
}
