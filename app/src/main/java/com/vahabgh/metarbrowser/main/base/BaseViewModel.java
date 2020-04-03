package com.vahabgh.metarbrowser.main.base;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {

    public ObservableBoolean errorObservableField = new ObservableBoolean(false);
    public ObservableBoolean loadingObservableField = new ObservableBoolean(false);


    protected void startLoading() {
        loadingObservableField.set(true);
    }

    protected void stopLoading() {
        loadingObservableField.set(false);
    }

    protected void showErrorView() {
        errorObservableField.set(true);
    }

    protected void hideErrorView() {
        errorObservableField.set(false);
    }

}
