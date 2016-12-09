package com.example.wladek.katanatemplate;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.wladek.katanatemplate.custom.CustomActivity;
import com.example.wladek.katanatemplate.ui.RecipeDetail;
import com.example.wladek.katanatemplate.ui.RecipeList;

public class DetailActivity extends CustomActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle("Recipes");
        addFragment();
    }

    private void addFragment() {
        if (getIntent().hasExtra("detail")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new RecipeDetail()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new RecipeList()).commit();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }
}
