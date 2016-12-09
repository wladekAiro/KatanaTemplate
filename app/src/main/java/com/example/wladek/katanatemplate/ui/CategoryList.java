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

public class CategoryList extends CustomFragment {
    private ArrayList<Data> catList;

    private class CategoryAdapter extends BaseAdapter {
        private CategoryAdapter() {
        }

        public int getCount() {
            return CategoryList.this.catList.size();
        }

        public Data getItem(int arg0) {
            return (Data) CategoryList.this.catList.get(arg0);
        }

        public long getItemId(int arg0) {
            return (long) arg0;
        }

        public View getView(int pos, View v, ViewGroup arg2) {
            if (v == null) {
                v = LayoutInflater.from(CategoryList.this.getActivity()).inflate(R.layout.cat_item, null);
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
        loadCategoryList();
        ListView list = (ListView) v.findViewById(R.id.list);
        list.setAdapter(new CategoryAdapter());
        list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View arg1, int pos, long arg3) {
                CategoryList.this.startActivity(new Intent(CategoryList.this.getActivity(), DetailActivity.class));
            }
        });
        setHasOptionsMenu(true);
        return v;
    }

    private void loadCategoryList() {
        ArrayList<Data> pList = new ArrayList();
        pList.add(new Data("Appetizer", "69", (int) R.drawable.cat1));
        pList.add(new Data("Bevarages", "42", (int) R.drawable.cat2));
        pList.add(new Data("Breakfasts", "87", (int) R.drawable.cat3));
        pList.add(new Data("Desserts", "34", (int) R.drawable.cat4));
        pList.add(new Data("Main Dishes", "94", (int) R.drawable.cat5));
        pList.add(new Data("Side Dishes", "12", (int) R.drawable.cat6));
        this.catList = new ArrayList(pList);
        this.catList.addAll(pList);
        this.catList.addAll(pList);
        this.catList.addAll(pList);
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
