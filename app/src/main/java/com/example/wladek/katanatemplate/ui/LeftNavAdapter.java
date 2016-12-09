package com.example.wladek.katanatemplate.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wladek.katanatemplate.R;
import com.example.wladek.katanatemplate.models.Data;

import java.util.ArrayList;

public class LeftNavAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Data> items;
    private int selected;

    public void setSelection(int position) {
        this.selected = position;
        notifyDataSetChanged();
    }

    public LeftNavAdapter(Context context, ArrayList<Data> items) {
        this.selected = 2;
        this.context = context;
        this.items = items;
    }

    public int getCount() {
        return this.items.size();
    }

    public Data getItem(int arg0) {
        return (Data) this.items.get(arg0);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.left_nav_item, null);
        }
        TextView lbl = (TextView) convertView;
        lbl.setText(getItem(position).getTitle1());
        if (position == this.selected) {
            lbl.setCompoundDrawablesWithIntrinsicBounds(getItem(position).getImage2(), 0, 0, 0);
            lbl.setBackgroundColor(this.context.getResources().getColor(R.color.main_color_gray_dk1));
            lbl.setTextColor(-1);
        } else {
            lbl.setCompoundDrawablesWithIntrinsicBounds(getItem(position).getImage1(), 0, 0, 0);
            lbl.setBackgroundResource(0);
            lbl.setTextColor(this.context.getResources().getColor(R.color.nav_color));
        }
        return convertView;
    }
}
