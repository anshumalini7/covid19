package com.example.covid19.MVC.detailsMVC;

import com.example.covid19.model.country.CountryList;
import com.example.covid19.model.countrycases.CountryCasesResponse;
import com.example.covid19.model.summary.CountryResponse;

import java.util.List;

/**
 * Created by Anshu Malini on 2020-11-26.
 */
public class DetailsContract {
    public interface IView {
        void countryCasesSuccess(List<CountryCasesResponse> response);

        void countryCasesFailure();
    }

    interface Presenter {

        void getCountryCases(String countryName);
    }

    interface Interactor {
        void getCountryCases(String countryName, iCountryCasesListener listener);

        interface iCountryCasesListener {
            void countryCasesSuccess(List<CountryCasesResponse> response);

            void countryCasesFailure();
        }
    }
}
