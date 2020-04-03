package com.vahabgh.metarbrowser.main.data.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vahabgh.metarbrowser.main.data.model.Airport;

import java.util.List;

@Dao
public interface MetarBrowserDao {

    @Query("SELECT * FROM airportentity")
    List<AirportEntity> getAllAirports();

    @Query("SELECT * FROM airportentity WHERE aliasName LIKE :aliasName  LIMIT 1")
    AirportEntity getByAliasName(String aliasName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AirportEntity airport);

}
