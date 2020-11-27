package com.example.covid19.MVC.summary;

import com.example.covid19.model.country.CountryList;
import com.example.covid19.model.summary.CountryResponse;

import java.util.List;

/**
 * Created by Anshu Malini on 2020-11-26.
 */
public class GlobalPresenter implements GlobalContract.Presenter, GlobalContract.Interactor.iSummaryListener, GlobalContract.Interactor.iCountriesListener {
    GlobalInterator interator;
    GlobalContract.IView iView;

    public GlobalPresenter(GlobalContract.IView iView) {
        this.iView = iView;
        interator = new GlobalInterator();
    }

    @Override
    public void getSummaryData() {
        interator.getSummaryData(this);
    }

    @Override
    public void getCountries() {
        interator.getCountries(this);
    }

    @Override
    public void summarySuccess(CountryResponse response) {
        iView.summarySuccess(response);

    }

    @Override
    public void summaryFailure() {
        iView.summaryFailure();
    }

    @Override
    public void countriesSuccess(List<CountryList> response) {
        iView.countriesSuccess(response);
    }

    @Override
    public void countriesFailure() {
        iView.countriesFailure();
    }
}
