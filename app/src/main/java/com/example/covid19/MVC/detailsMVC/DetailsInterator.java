package com.example.covid19.MVC.detailsMVC;

import android.util.Log;

import com.example.covid19.model.country.CountryList;
import com.example.covid19.model.countrycases.CountryCasesResponse;
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
public class DetailsInterator implements DetailsContract.Interactor {

    @Override
    public void getCountryCases(String countryName, final iCountryCasesListener listener) {
        APIClient.getClient().create(APIInterface.class).callCountryCasesData(countryName)
                .enqueue(new Callback<List<CountryCasesResponse>>() {
                    @Override
                    public void onResponse(Call<List<CountryCasesResponse>> call, Response<List<CountryCasesResponse>> response) {
                        listener.countryCasesSuccess(response.body());
                        Log.e("ANSHU", response.body() + "");
                    }

                    @Override
                    public void onFailure(Call<List<CountryCasesResponse>> call, Throwable t) {
                        listener.countryCasesFailure();
                    }
                });
    }
}
