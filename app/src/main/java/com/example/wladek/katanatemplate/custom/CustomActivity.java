package com.example.wladek.katanatemplate.custom;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.wladek.katanatemplate.R;
import com.example.wladek.katanatemplate.utils.TouchEffect;

public class CustomActivity extends FragmentActivity implements OnClickListener {
    public static final TouchEffect TOUCH;

    static {
        TOUCH = new TouchEffect();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
    }

    protected void setupActionBar() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setNavigationMode(0);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setLogo(R.drawable.icon);
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_bg));
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    public View setTouchNClick(int id) {
        View v = setClick(id);
        if (v != null) {
            v.setOnTouchListener(TOUCH);
        }
        return v;
    }

    public View setClick(int id) {
        View v = findViewById(id);
        if (v != null) {
            v.setOnClickListener(this);
        }
        return v;
    }

    public void onClick(View v) {
    }
}
