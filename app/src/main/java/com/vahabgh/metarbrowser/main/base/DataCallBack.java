package com.vahabgh.metarbrowser.main.base;

import com.vahabgh.metarbrowser.main.data.model.Airport;

public interface DataCallBack<T> {

    void onSuccess(T airport);

    void onFailure(Exception exp);

}
