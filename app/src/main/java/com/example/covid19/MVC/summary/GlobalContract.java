package com.example.covid19.MVC.summary;

import com.example.covid19.model.country.CountryList;
import com.example.covid19.model.summary.CountryResponse;

import java.util.List;

/**
 * Created by Anshu Malini on 2020-11-26.
 */
public class GlobalContract {
    public interface IView {
        void summarySuccess(CountryResponse response);

        void summaryFailure();

        void countriesSuccess(List<CountryList> response);

        void countriesFailure();
    }

    interface Presenter {
        void getSummaryData();

        void getCountries();
    }

    interface Interactor {
        void getSummaryData(iSummaryListener listener);

        void getCountries(iCountriesListener listener);

        interface iSummaryListener {
            void summarySuccess(CountryResponse response);

            void summaryFailure();
        }

        interface iCountriesListener {
            void countriesSuccess(List<CountryList> response);

            void countriesFailure();
        }
    }
}
