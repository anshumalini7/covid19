package com.example.covid19.MVC.detailsMVC;

import com.example.covid19.model.countrycases.CountryCasesResponse;

import java.util.List;

/**
 * Created by Anshu Malini on 2020-11-26.
 */
public class DetailsPresenter implements DetailsContract.Presenter, DetailsContract.Interactor.iCountryCasesListener {
    DetailsInterator interator;
    DetailsContract.IView iView;

    public DetailsPresenter(DetailsContract.IView iView) {
        this.iView = iView;
        interator = new DetailsInterator();
    }

    @Override
    public void getCountryCases(String countryName) {
        interator.getCountryCases(countryName, this);
    }

    @Override
    public void countryCasesSuccess(List<CountryCasesResponse> response) {
        iView.countryCasesSuccess(response);
    }

    @Override
    public void countryCasesFailure() {
        iView.countryCasesFailure();
    }
}
