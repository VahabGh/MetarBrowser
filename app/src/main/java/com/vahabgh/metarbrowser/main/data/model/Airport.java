package com.vahabgh.metarbrowser.main.data.model;

public class Airport {

    private String name;
    private String date;
    private String wind;
    private String visibility;
    private String temperature;
    private String windChill;
    private String dewPoint;
    private String relativeHumidity;
    private String weather;
    private String ob;
    private String cycle;
    private String pressureAltimeter;
    private String skyConditions;

    private Airport(Builder builder) {
        this.name = builder.name;
        this.date = builder.date;
        this.wind = builder.wind;
        this.visibility = builder.visibility;
        this.temperature = builder.temperature;
        this.windChill = builder.windChill;
        this.dewPoint = builder.dewPoint;
        this.relativeHumidity = builder.relativeHumidity;
        this.weather = builder.weather;
        this.ob = builder.ob;
        this.cycle = builder.cycle;
        this.pressureAltimeter = builder.pressureAltimeter;
        this.skyConditions = builder.skyConditions;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getWind() {
        return wind;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWindChill() {
        return windChill;
    }

    public String getDewPoint() {
        return dewPoint;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public String getWeather() {
        return weather;
    }

    public String getOb() {
        return ob;
    }

    public String getCycle() {
        return cycle;
    }

    public String getPressureAltimeter() {
        return pressureAltimeter;
    }

    public String getSkyConditions() {
        return skyConditions;
    }

    public static class Builder {

        private String name;
        private String date;
        private String wind;
        private String visibility;
        private String temperature;
        private String windChill;
        private String dewPoint;
        private String relativeHumidity;
        private String weather;
        private String ob;
        private String cycle;
        private String pressureAltimeter;
        private String skyConditions;

        public Builder() {

        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Builder wind(String wind) {
            this.wind = wind;
            return this;
        }

        public Builder visibility(String visibility) {
            this.visibility = visibility;
            return this;
        }

        public Builder temperature(String temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder windChill(String windChill) {
            this.windChill = windChill;
            return this;
        }

        public Builder dewPoint(String dewPoint) {
            this.dewPoint = dewPoint;
            return this;
        }

        public Builder relativeHumidity(String relativeHumidity) {
            this.relativeHumidity = relativeHumidity;
            return this;
        }

        public Builder weather(String weather) {
            this.weather = weather;
            return this;
        }

        public Builder ob(String ob) {
            this.ob = ob;
            return this;
        }

        public Builder cycle(String cycle) {
            this.cycle = cycle;
            return this;
        }

        public Builder pressureAltimeter(String pressureAltimeter) {
            this.pressureAltimeter = pressureAltimeter;
            return this;
        }

        public Builder skyConditions(String skyConditions) {
            this.skyConditions = skyConditions;
            return this;
        }

        public Airport build(){
            return new Airport(this);
        }
    }

}
