package com.example.wladek.katanatemplate.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wladek.katanatemplate.R;
import com.example.wladek.katanatemplate.custom.CustomFragment;

public class RecipeDetail extends CustomFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recipe_detail, null);
        setHasOptionsMenu(true);
        setTouchNClick(v.findViewById(R.id.btn));
        return v;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.compose, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
