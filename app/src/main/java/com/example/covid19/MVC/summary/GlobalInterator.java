package com.example.covid19.MVC.summary;

import android.util.Log;

import com.example.covid19.model.country.CountryList;
import com.example.covid19.model.summary.CountryResponse;
import com.example.covid19.utils.APIClient;
import com.example.covid19.utils.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Anshu Malini on 2020-11-26.
 */
public class GlobalInterator implements GlobalContract.Interactor {

    @Override
    public void getSummaryData(final iSummaryListener listener) {
        APIClient.getClient().create(APIInterface.class).callSummaryData()
                .enqueue(new Callback<CountryResponse>() {
                    @Override
                    public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                        listener.summarySuccess(response.body());
                        Log.e("ANSHU", response.body() + "");
                    }

                    @Override
                    public void onFailure(Call<CountryResponse> call, Throwable t) {
                        listener.summaryFailure();
                    }
                });
    }

    @Override
    public void getCountries(final iCountriesListener listener) {
        APIClient.getClient().create(APIInterface.class).callCountryData()
                .enqueue(new Callback<List<CountryList>>() {
                    @Override
                    public void onResponse(Call<List<CountryList>> call, Response<List<CountryList>> response) {
                        listener.countriesSuccess(response.body());
                        Log.e("ANSHU", response.body() + "");
                    }

                    @Override
                    public void onFailure(Call<List<CountryList>> call, Throwable t) {
                        listener.countriesFailure();
                    }
                });
    }
}
