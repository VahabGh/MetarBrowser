package com.vahabgh.metarbrowser.main.data.repository;

import com.vahabgh.metarbrowser.main.base.DataCallBack;
import com.vahabgh.metarbrowser.main.data.model.Airport;

public interface Repository {

     void getData(String query, DataCallBack<Airport> dataCallBack);

}
