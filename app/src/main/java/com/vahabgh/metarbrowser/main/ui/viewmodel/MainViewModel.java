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

public class MainViewModel extends BaseViewModel {

    private Repository repository;
    public ObservableField<Airport> airportObservableField;

    public MainViewModel(Repository repository) {
        this.repository = repository;
        airportObservableField = new ObservableField<>();
        errorObservableField = new ObservableBoolean(false);
        loadingObservableField = new ObservableBoolean(false);
    }

    public void getData(String query) {

        startLoading();
        hideErrorView();

        repository.getData(query, new DataCallBack<Airport>() {
            @Override
            public void onSuccess(Airport airport) {
                stopLoading();
                airportObservableField.set(airport);
            }

            @Override
            public void onFailure(Exception exp) {
                stopLoading();
                showErrorView();
            }
        });

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
