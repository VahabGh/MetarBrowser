package com.vahabgh.metarbrowser.main.data.model;

import com.vahabgh.metarbrowser.main.data.db.AirportEntity;

public interface AirportDataMapper {

    Airport map(String data);

    AirportEntity map(String aliasName,Airport airport);

    Airport map(AirportEntity airportEntity);

}
