package com.vahabgh.metarbrowser.main.data.db;

import com.vahabgh.metarbrowser.main.base.DataCallBack;
import com.vahabgh.metarbrowser.main.data.model.Airport;

public interface MetarCacheService {

    void saveInCache(AirportEntity airportEntity);

    void readFromCache(String aliasName,DataCallBack<Airport> callBack);

}
