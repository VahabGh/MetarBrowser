package com.vahabgh.metarbrowser.main.data.model;

import com.vahabgh.metarbrowser.main.data.db.AirportEntity;

import java.util.List;

public class AirportDataParser {

    public static Airport convertAirportEntityToAirport(AirportEntity airportEntity) {
        return new Airport.Builder()
                .name(airportEntity.getName())
                .date(airportEntity.getDate())
                .wind(airportEntity.getWind())
                .visibility(airportEntity.getVisibility())
                .temperature(airportEntity.getTemperature())
                .windChill(airportEntity.getWindChill())
                .dewPoint(airportEntity.getDewPoint())
                .relativeHumidity(airportEntity.getRelativeHumidity())
                .weather(airportEntity.getWeather())
                .ob(airportEntity.getOb())
                .cycle(airportEntity.getCycle())
                .pressureAltimeter(airportEntity.getPressureAltimeter())
                .skyConditions(airportEntity.getSkyConditions())
                .build();

    }

    public static AirportEntity convertAirportToAirportEntity(String aliasName,Airport airport){
        AirportEntity airportEntity =  new AirportEntity();

        airportEntity.setAliasName(aliasName);
        airportEntity.setName(airport.getName());
        airportEntity.setDate(airport.getDate());
        airportEntity.setWind(airport.getWind());
        airportEntity.setVisibility(airport.getVisibility());
        airportEntity.setTemperature(airport.getTemperature());
        airportEntity.setWindChill(airport.getWindChill());
        airportEntity.setDewPoint(airport.getDewPoint());
        airportEntity.setRelativeHumidity(airport.getRelativeHumidity());
        airportEntity.setWeather(airport.getWeather());
        airportEntity.setOb(airport.getOb());
        airportEntity.setCycle(airport.getCycle());
        airportEntity.setPressureAltimeter(airport.getPressureAltimeter());
        airportEntity.setSkyConditions(airport.getSkyConditions());

        return airportEntity;
    }

    public static Airport parseDataToAirPort(List<String> lines) {

        if (lines == null || lines.size() <= 0) return null;

        String name = "-";
        String date = "-";
        String wind = "-";
        String visibility = "-";
        String temperature = "-";
        String windChill = "-";
        String dewPoint = "-";
        String relativeHumidity = "-";
        String weather = "-";
        String ob = "-";
        String cycle = "-";
        String pressureAltimeter = "-";
        String skyConditions = "-";


        int count = 0;

        for (String item : lines) {

            //first line is always name of the airport
            if (count == 0)
                name = item;

            // the second line is always date.
            if (count == 1)
                date = item;

            if (item.startsWith(AirportProperties.Wind.getKey()))
                wind = getValueAfterFirstColumn(item);

            if (item.startsWith(AirportProperties.Visibility.getKey()))
                visibility = getValueAfterFirstColumn(item);

            if (item.startsWith(AirportProperties.Temperature.getKey()))
                temperature = getValueAfterFirstColumn(item);

            if (item.startsWith(AirportProperties.Windchill.getKey()))
                windChill = getValueAfterFirstColumn(item);

            if (item.startsWith(AirportProperties.Dew_Point.getKey()))
                dewPoint = getValueAfterFirstColumn(item);

            if (item.startsWith(AirportProperties.Relative_Humidity.getKey()))
                relativeHumidity = getValueAfterFirstColumn(item);

            if (item.startsWith(AirportProperties.Weather.getKey()))
                weather = getValueAfterFirstColumn(item);

            if (item.startsWith(AirportProperties.ob.getKey()))
                ob = getValueAfterFirstColumn(item);

            if (item.startsWith(AirportProperties.cycle.getKey()))
                cycle = getValueAfterFirstColumn(item);

            if (item.startsWith(AirportProperties.Pressure_altimeter.getKey()))
                pressureAltimeter = getValueAfterFirstColumn(item);

            if (item.startsWith(AirportProperties.Sky_conditions.getKey()))
                skyConditions = getValueAfterFirstColumn(item);

            count++;
        }

        return new Airport.Builder()
                .name(name)
                .date(date)
                .wind(wind)
                .visibility(visibility)
                .temperature(temperature)
                .windChill(windChill)
                .dewPoint(dewPoint)
                .relativeHumidity(relativeHumidity)
                .weather(weather)
                .ob(ob)
                .cycle(cycle)
                .pressureAltimeter(pressureAltimeter)
                .skyConditions(skyConditions)
                .build();
    }

    public static String getValueAfterFirstColumn(String item) {

        if (item.equals("")) return "-";

        int firstColumnChatIndex = 0;

        for (int index = 0; index < item.length(); index++)
            if (item.charAt(index) == ':') {
                firstColumnChatIndex = index;
                break;
            }

        return item.substring(firstColumnChatIndex + 1).trim();
    }


}
