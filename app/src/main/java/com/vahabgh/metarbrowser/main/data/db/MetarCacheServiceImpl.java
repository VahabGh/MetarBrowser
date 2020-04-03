package com.vahabgh.metarbrowser.main.data.db;

import android.content.Context;
import android.os.AsyncTask;

import com.vahabgh.metarbrowser.main.base.DataCallBack;
import com.vahabgh.metarbrowser.main.data.model.Airport;
import com.vahabgh.metarbrowser.main.data.model.AirportDataParser;

import java.io.FileNotFoundException;

public class MetarCacheServiceImpl implements MetarCacheService {

    private Context applicationContext;

    public MetarCacheServiceImpl(Context applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public void saveInCache(AirportEntity airportEntity) {
        new SaveTask(airportEntity).execute();
    }

    class SaveTask extends AsyncTask<Void, Void, Void> {

        private AirportEntity airport;


        public SaveTask(AirportEntity airport) {
            this.airport = airport;

        }

        @Override
        protected Void doInBackground(Void... voids) {
            AppDatabase.get(applicationContext).metarBrowserDao()
                    .insert(airport);
            return null;
        }
    }


    @Override
    public void readFromCache(String aliasName, DataCallBack<Airport> callBack) {
        new ReadTask(aliasName, callBack).execute();
    }


    class ReadTask extends AsyncTask<Void, AirportEntity, AirportEntity> {

        private DataCallBack<Airport> callBack;
        private String aliasName;

        public ReadTask(String aliasName, DataCallBack<Airport> callBack) {
            this.callBack = callBack;
            this.aliasName = aliasName;
        }

        @Override
        protected AirportEntity doInBackground(Void... voids) {
            return AppDatabase.get(applicationContext).metarBrowserDao().getByAliasName(aliasName);
        }

        @Override
        protected void onPostExecute(AirportEntity airport) {
            super.onPostExecute(airport);
            if (callBack != null) {
                if (airport != null)
                    callBack.onSuccess(AirportDataParser.convertAirportEntityToAirport(airport));
                else
                    callBack.onFailure(new FileNotFoundException());
            }
        }
    }
}
