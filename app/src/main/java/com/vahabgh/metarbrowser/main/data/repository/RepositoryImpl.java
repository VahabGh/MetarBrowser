package com.vahabgh.metarbrowser.main.data.repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.vahabgh.metarbrowser.main.data.api.TextFileDownloadListener;
import com.vahabgh.metarbrowser.main.data.api.TextFileDownloader;
import com.vahabgh.metarbrowser.main.data.db.AirportEntity;
import com.vahabgh.metarbrowser.main.data.db.MetarCacheService;
import com.vahabgh.metarbrowser.main.data.model.AirportDataMapper;
import com.vahabgh.metarbrowser.main.data.model.Airport;
import com.vahabgh.metarbrowser.main.base.DataCallBack;

import java.io.FileNotFoundException;

public class RepositoryImpl implements Repository {

    private DataCallBack<Airport> dataCallBack;
    private TextFileDownloader textFileDownloader;
    private MetarCacheService metarCacheService;
    private Context applicationContext;
    private AirportDataMapper airportDataMapper;

    public RepositoryImpl(Context applicationContext,MetarCacheService metarCacheService, TextFileDownloader textFileDownloader,AirportDataMapper airportDataMapper) {
        this.textFileDownloader = textFileDownloader;
        this.metarCacheService = metarCacheService;
        this.applicationContext = applicationContext;
        this.airportDataMapper = airportDataMapper;
    }

    @Override
    public void getData(String query, DataCallBack<Airport> dataCallBack) {

        if (airportDataMapper == null)
            throw new IllegalArgumentException("repository needs a dataMapper implementation :)");

        this.dataCallBack = dataCallBack;

        if (isNetworkConnected())
            downloadTextFile(query);
        else
            readFromCache(query);

    }

    private void readFromCache(String query) {
        if (metarCacheService == null)
            return;

        metarCacheService.readFromCache(query, new DataCallBack<AirportEntity>() {
            @Override
            public void onSuccess(AirportEntity airport) {
                dataCallBack.onSuccess(airportDataMapper.map(airport));
            }

            @Override
            public void onFailure(Exception exp) {
                dataCallBack.onFailure(exp);
            }
        });
    }

    private void downloadTextFile(final String query) {
        if (textFileDownloader == null)
            return;

        textFileDownloader.setPath("https://tgftp.nws.noaa.gov/data/observations/metar/decoded/" + query + ".TXT");
        textFileDownloader.setTextFileDownloadListener(new TextFileDownloadListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete(String text) {
                Airport airport = airportDataMapper.map(text);
                dataCallBack.onSuccess(airport);
                saveInCache(query, airport);
            }

            @Override
            public void onError(Exception exp) {
                if (exp instanceof FileNotFoundException) {
                    dataCallBack.onFailure(exp);
                    return;
                }

                readFromCache(query);
            }
        });
        textFileDownloader.start();

    }


    private void saveInCache(String query, Airport airport) {
        metarCacheService.saveInCache(airportDataMapper.map(query, airport));
    }

    public  boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null)
            return false;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();

    }
}

