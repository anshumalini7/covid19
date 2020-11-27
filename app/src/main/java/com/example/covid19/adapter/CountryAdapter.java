package com.example.covid19.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.R;
import com.example.covid19.model.summary.CountriesItem;
import com.example.covid19.ui.HomeDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshu Malini on 2020-11-26.
 */
public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private ArrayList<CountriesItem> arrayList;
    private Activity mContext;

    public CountryAdapter(ArrayList<CountriesItem> arrayList, Activity mContext) {
        this.arrayList = new ArrayList<>();
        this.arrayList.addAll(arrayList);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,
                false);
        return new ViewHolder(view);
    }

    public void updateUI(List<CountriesItem> countries) {
        this.arrayList.clear();
        this.arrayList.addAll(countries);
        notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(arrayList.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public interface ItemClickListener {
        void onClick(String countryName);
    }

    private ItemClickListener mItemClickListener;

    public void setClickListener(ItemClickListener clickListener) {
        this.mItemClickListener = clickListener;
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mItemClickListener.onClick(arrayList.get(getAdapterPosition()).getSlug());
        }
    }

}
