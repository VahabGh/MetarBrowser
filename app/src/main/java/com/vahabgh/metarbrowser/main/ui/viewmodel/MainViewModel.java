package com.vahabgh.metarbrowser.main.ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.vahabgh.metarbrowser.main.base.BaseViewModel;
import com.vahabgh.metarbrowser.main.data.model.Airport;
import com.vahabgh.metarbrowser.main.data.repository.Repository;
import com.vahabgh.metarbrowser.main.base.DataCallBack;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeoutException;

public class MainViewModel extends BaseViewModel {

    private Repository repository;
    public ObservableField<Airport> airportObservableField;
    public ObservableField<String> queryFieldValidation;

    public MainViewModel(Repository repository) {
        this.repository = repository;
        airportObservableField = new ObservableField<>();
        errorObservableField = new ObservableBoolean(false);
        loadingObservableField = new ObservableBoolean(false);
        queryFieldValidation = new ObservableField<>("");
    }

    public void getData(String query) {

        if (!isQueryValid(query)) return;
        startLoading();
        hideErrorView();
        airportObservableField.set(null);

        repository.getData(query.toUpperCase(), new DataCallBack<Airport>() {
            @Override
            public void onSuccess(Airport airport) {
                stopLoading();
                airportObservableField.set(airport);
            }

            @Override
            public void onFailure(Exception exp) {
                stopLoading();
                showErrorView();
                handleErrorException(exp);
            }
        });

    }

    private void handleErrorException(Exception exp) {

        if (exp instanceof TimeoutException){
            queryFieldValidation.set("Network connection problem");
            return;
        }

        if (exp instanceof FileNotFoundException) {
            queryFieldValidation.set("No data found");
            return;
        }

        queryFieldValidation.set("Some problem happened");
    }

    private boolean isQueryValid(String query) {
        if (query.isEmpty()) {
            queryFieldValidation.set("which air port you looking for?");
            showErrorView();
            return false;
        }

        if (!query.toLowerCase().startsWith("ed")) {
            queryFieldValidation.set("German airports starts with ED ");
            showErrorView();
            return false;
        }

        return true;
    }


    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        private final Repository mRepository;

        public Factory(Repository mRepository) {
            this.mRepository = mRepository;
        }

        @SuppressWarnings("unchecked")
        @Override
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MainViewModel(mRepository);
        }
    }
}
