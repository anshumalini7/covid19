package com.example.covid19.utils;

import com.example.covid19.model.country.CountryList;
import com.example.covid19.model.countrycases.CountryCasesResponse;
import com.example.covid19.model.summary.CountryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Anshu Malini on 2020-11-26.
 */
public interface APIInterface {

    @GET(Contants.SUMMARY_URL)
    Call<CountryResponse> callSummaryData();

    @GET(Contants.COUNRTY_URL)
    Call<List<CountryList>> callCountryData();

    @GET(Contants.COUNRTY_CASES_URL)
    Call<List<CountryCasesResponse>> callCountryCasesData(@Path("Slug") String countryName);

}
