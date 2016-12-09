package com.example.wladek.katanatemplate.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wladek.katanatemplate.DetailActivity;
import com.example.wladek.katanatemplate.R;
import com.example.wladek.katanatemplate.Search;
import com.example.wladek.katanatemplate.custom.CustomFragment;
import com.example.wladek.katanatemplate.models.Data;

import java.util.ArrayList;

public class RecipeList extends CustomFragment {
    private ArrayList<Data> recipeList;

    private class RecipeAdapter extends BaseAdapter {
        private RecipeAdapter() {
        }

        public int getCount() {
            return RecipeList.this.recipeList.size();
        }

        public Data getItem(int arg0) {
            return (Data) RecipeList.this.recipeList.get(arg0);
        }

        public long getItemId(int arg0) {
            return (long) arg0;
        }

        public View getView(int pos, View v, ViewGroup arg2) {
            if (v == null) {
                v = LayoutInflater.from(RecipeList.this.getActivity()).inflate(R.layout.recipe_item, null);
            }
            Data c = getItem(pos);
            ((TextView) v.findViewById(R.id.lbl1)).setText(c.getTitle1());
            ((TextView) v.findViewById(R.id.lbl2)).setText(c.getDesc());
            ((ImageView) v.findViewById(R.id.img1)).setImageResource(c.getImage1());
            return v;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recipe_list, null);
        loadRecipeList();
        ListView list = (ListView) v.findViewById(R.id.list);
        list.setAdapter(new RecipeAdapter());
        list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View arg1, int pos, long arg3) {
                RecipeList.this.startActivity(new Intent(RecipeList.this.getActivity(), DetailActivity.class).putExtra("detail", true));
            }
        });
        setHasOptionsMenu(true);
        return v;
    }

    private void loadRecipeList() {
        ArrayList<Data> pList = new ArrayList();
        pList.add(new Data("Mandarian Sorbet", "by John Doe", (int) R.drawable.img1));
        pList.add(new Data("Blackberry Sorbet", "by Stansil Kirilov", (int) R.drawable.img2));
        pList.add(new Data("Mango Sorbet", "by John Doe", (int) R.drawable.img3));
        pList.add(new Data("Strawberry Sorbet", "by Steve Thomas", (int) R.drawable.img4));
        pList.add(new Data("Apple Sorbet", "by Mark Kratzman", (int) R.drawable.img5));
        pList.add(new Data("Sweet Sorbet", "by Selene Setty", (int) R.drawable.img6));
        this.recipeList = new ArrayList(pList);
        this.recipeList.addAll(pList);
        this.recipeList.addAll(pList);
        this.recipeList.addAll(pList);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_search) {
            startActivity(new Intent(getActivity(), Search.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
