package com.example.covid19.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.MVC.detailsMVC.DetailsContract;
import com.example.covid19.MVC.detailsMVC.DetailsPresenter;
import com.example.covid19.R;
import com.example.covid19.adapter.CountryAdapter;
import com.example.covid19.adapter.CountryCasesAdapter;
import com.example.covid19.model.countrycases.CountryCasesResponse;
import com.example.covid19.model.summary.CountriesItem;
import com.example.covid19.model.summary.CountryResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.covid19.utils.Contants.FAILURE_MSG;

/**
 * Created by Anshu Malini on 2020-11-26.
 */
public class HomeDetails extends AppCompatActivity implements DetailsContract.IView {

    @BindView(R.id.countryCasesList)
    RecyclerView countryCasesList;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    String countryName;
    DetailsPresenter presenter;

    ArrayList<CountryCasesResponse> aList;
    CountryCasesAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_details);
        ButterKnife.bind(this);

        countryName = getIntent().getStringExtra("countryName");
        presenter = new DetailsPresenter(this);

        presenter.getCountryCases(countryName);
        countryCasesList.setLayoutManager(new GridLayoutManager(this, 2));

        aList = new ArrayList<CountryCasesResponse>();
        adapter = new CountryCasesAdapter(aList, this);
        countryCasesList.setAdapter(adapter);

    }

    @Override
    public void countryCasesSuccess(List<CountryCasesResponse> response) {
        progressBar.setVisibility(View.GONE);
        countryCasesList.setVisibility(View.VISIBLE);
        aList.clear();
        aList.addAll(response);
        adapter.updateUI(aList);
    }

    @Override
    public void countryCasesFailure() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, FAILURE_MSG, Toast.LENGTH_SHORT).show();
    }
}
