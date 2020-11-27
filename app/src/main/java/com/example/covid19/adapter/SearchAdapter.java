package com.example.covid19.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;

import com.example.covid19.model.country.CountryList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshu Malini on 2020-11-26.
 */
public class SearchAdapter extends ArrayAdapter<CountryList> {
    ArrayList<CountryList> arrayList;

//    public SearchAdapter(ArrayList<CountryList> alist) {
//        arrayList = new ArrayList<CountryList>();
//        this.arrayList.addAll(alist);
//    }
//
//    @Override
//    public int getCount() {
//        return arrayList.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        return null;
//    }
    public SearchAdapter(Context context, int resource, List<CountryList> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public CountryList getItem(int position) {
        return super.getItem(position);
    }
    @Override
    public Filter getFilter() {
        return super.getFilter();
    }
}
