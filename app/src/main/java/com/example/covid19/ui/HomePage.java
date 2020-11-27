package com.example.covid19.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.MVC.summary.GlobalContract;
import com.example.covid19.MVC.summary.GlobalPresenter;
import com.example.covid19.R;
import com.example.covid19.adapter.CountryAdapter;
import com.example.covid19.adapter.SearchAdapter;
import com.example.covid19.model.country.CountryList;
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
public class HomePage extends AppCompatActivity implements GlobalContract.IView, CountryAdapter.ItemClickListener {

    @BindView(R.id.countryList)
    RecyclerView countryList;

    @BindView(R.id.totalConfirmedTV)
    TextView totalConfirmedTV;

    @BindView(R.id.NewConfirmedTV)
    TextView NewConfirmedTV;

    @BindView(R.id.NewDeathsTV)
    TextView NewDeathsTV;

    @BindView(R.id.TotalDeathsTV)
    TextView TotalDeathsTV;

    @BindView(R.id.NewRecoveredTV)
    TextView NewRecoveredTV;

    @BindView(R.id.TotalRecoveredTV)
    TextView TotalRecoveredTV;

    @BindView(R.id.scrollView)
    NestedScrollView scrollView;

    @BindView(R.id.autoCompleteTextView)
    AutoCompleteTextView autoCompleteTextView;

    @BindView(R.id.cancelImg)
    ImageView cancelImg;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    CountryAdapter adapter;

    ArrayList<CountriesItem> aList;
    List<CountryList> searchCountry;
    List<String> searchCountryStrList;

    GlobalPresenter presenter;
    SearchAdapter searchAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        ButterKnife.bind(this);
        presenter = new GlobalPresenter(this);
        countryList.setLayoutManager(new GridLayoutManager(this, 2));
        countryList.setNestedScrollingEnabled(false);
        aList = new ArrayList<CountriesItem>();
        searchCountry = new ArrayList<CountryList>();
        searchCountryStrList = new ArrayList<>();
        presenter.getSummaryData();
        presenter.getCountries();
        adapter = new CountryAdapter(aList, this);
        adapter.setClickListener(this);
        countryList.setAdapter(adapter);
        scrollView.setVisibility(View.GONE);
        cancelImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoCompleteTextView.setText("");
            }
        });
        searchAdapter = new SearchAdapter(this,
                android.R.layout.simple_list_item_1, searchCountry);

    }

    @Override
    public void summarySuccess(CountryResponse response) {
        progressBar.setVisibility(View.GONE);
        scrollView.setVisibility(View.VISIBLE);
        aList.clear();
        aList.addAll(response.getCountries());
        adapter.updateUI(response.getCountries());
        totalConfirmedTV.setText("" + response.getGlobal().getTotalConfirmed());
        NewConfirmedTV.setText("" + response.getGlobal().getNewConfirmed());
        NewDeathsTV.setText("" + response.getGlobal().getNewDeaths());
        TotalDeathsTV.setText("" + response.getGlobal().getTotalDeaths());
        NewRecoveredTV.setText("" + response.getGlobal().getNewRecovered());
        TotalRecoveredTV.setText("" + response.getGlobal().getTotalRecovered());
    }

    @Override
    public void summaryFailure() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, FAILURE_MSG, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void countriesSuccess(List<CountryList> response) {
        searchCountry.addAll(response);
        for (int i = 0; i < searchCountry.size(); i++) {
            searchCountryStrList.add(searchCountry.get(i).getCountry());
        }
        searchAdapter.setNotifyOnChange(true);

        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(searchAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                onClick(searchAdapter.getItem(i));
                onClick(searchAdapter.getItem(i).getSlug());
            }
        });
    }

    @Override
    public void countriesFailure() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, FAILURE_MSG, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(String countryName) {
        Intent intent = new Intent(this, HomeDetails.class);
        intent.putExtra("countryName", countryName);
        startActivity(intent);
    }
}
