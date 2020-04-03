package com.vahabgh.metarbrowser.main.data.model;

public enum AirportProperties {

    Name("name"),
    Date("date"),
    Wind("Wind"),
    Visibility("Wind"),
    Temperature("Temperature"),
    Windchill("Windchill"),
    Dew_Point("Dew Point"),
    Relative_Humidity("Relative Humidity"),
    Weather("Weather"),
    ob("ob"),
    cycle("cycle"),
    Pressure_altimeter("Pressure (altimeter)"),
    Sky_conditions("Sky conditions");

    AirportProperties(String key) {
        this.key = key;
    }

    private String key;

    public String getKey() {
        return key;
    }
}
