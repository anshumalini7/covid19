package com.example.covid19.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.R;
import com.example.covid19.model.countrycases.CountryCasesResponse;
import com.example.covid19.model.summary.CountriesItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshu Malini on 2020-11-26.
 */
public class CountryCasesAdapter extends RecyclerView.Adapter<CountryCasesAdapter.ViewHolder> {
    private ArrayList<CountryCasesResponse> arrayList;
    Activity mContext;

    public CountryCasesAdapter(ArrayList<CountryCasesResponse> arrayList, Activity mContext) {
        this.mContext = mContext;
        this.arrayList = new ArrayList<>();
        this.arrayList.addAll(arrayList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_details_list_item, parent,
                false);

        return new ViewHolder(view);
    }

    public void updateUI(List<CountryCasesResponse> countries) {
        this.arrayList.clear();
        this.arrayList.addAll(countries);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CountryCasesResponse obj = arrayList.get(position);
        holder.Country.setText(obj.getCountry());
        holder.Province.setText(obj.getProvince());
        holder.Confirmed.setText("" + obj.getConfirmed());
        holder.Deaths.setText("" + obj.getDeaths());
        holder.Recovered.setText("" + obj.getRecovered());
        holder.Active.setText("" + obj.getActive());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView Country, Province, Confirmed, Deaths, Recovered, Active;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Country = itemView.findViewById(R.id.Country);
            Province = itemView.findViewById(R.id.Province);
            Confirmed = itemView.findViewById(R.id.Confirmed);
            Deaths = itemView.findViewById(R.id.Deaths);
            Recovered = itemView.findViewById(R.id.Recovered);
            Active = itemView.findViewById(R.id.Active);
        }
    }

}
