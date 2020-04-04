package com.vahabgh.metarbrowser.main.data.model;

import org.junit.Test;

public class MapperTest {

    @Test
    public void map() {

        AirportDataMapper mapper = new AirportDataMapperImpl();
        Airport airport = mapper.map(getPlainText());
        assert (!airport.getName().equals(""));
        assert (!airport.getDate().equals(""));
        assert (!airport.getWind().equals(""));
        assert (!airport.getVisibility().equals(""));
        assert (!airport.getWindChill().equals(""));
        assert (!airport.getPressureAltimeter().equals(""));
        assert (!airport.getDewPoint().equals(""));
        assert (!airport.getOb().equals(""));
        assert (!airport.getTemperature().equals(""));
        assert (!airport.getRelativeHumidity().equals(""));
        assert (checkCycleData(airport.getCycle()));
    }

    private boolean checkCycleData(String cycle) {

        try {
            Integer.parseInt(cycle);
            return true;
        }
        catch (Exception exp){
            return false;
        }

    }

    public String getPlainText() {
        return "Dresden-Klotzsche, Germany (EDDC) 51-08N 013-45E 232M\n" +
                "Apr 04, 2020 - 09:20 AM EDT / 2020.04.04 1320 UTC\n" +
                "Wind: from the WNW (300 degrees) at 3 MPH (3 KT) (direction variable):0\n" +
                "Visibility: greater than 7 mile(s):0\n" +
                "Sky conditions: mostly clear\n" +
                "Temperature: 50 F (10 C)\n" +
                "Dew Point: 32 F (0 C)\n" +
                "Relative Humidity: 49%\n" +
                "Pressure (altimeter): 30.27 in. Hg (1025 hPa)\n" +
                "ob: EDDC 041320Z 30003KT 240V350 9999 FEW040 10/M00 Q1025 NOSIG\n" +
                "cycle: 12";
    }

}
