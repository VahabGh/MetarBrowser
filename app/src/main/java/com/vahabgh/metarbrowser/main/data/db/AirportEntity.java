package com.vahabgh.metarbrowser.main.data.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AirportEntity")
public class AirportEntity {

    @PrimaryKey
    @ColumnInfo(name = "aliasName")
    @NonNull
    public String aliasName;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "wind")
    private String wind;

    @ColumnInfo(name = "visibility")
    private String visibility;

    @ColumnInfo(name = "temperature")
    private String temperature;

    @ColumnInfo(name = "windChill")
    private String windChill;

    @ColumnInfo(name = "dewPoint")
    private String dewPoint;

    @ColumnInfo(name = "relativeHumidity")
    private String relativeHumidity;

    @ColumnInfo(name = "weather")
    private String weather;

    @ColumnInfo(name = "ob")
    private String ob;

    @ColumnInfo(name = "cycle")
    private String cycle;

    @ColumnInfo(name = "pressureAltimeter")
    private String pressureAltimeter;

    @ColumnInfo(name = "skyConditions")
    private String skyConditions;

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWindChill() {
        return windChill;
    }

    public void setWindChill(String windChill) {
        this.windChill = windChill;
    }

    public String getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(String dewPoint) {
        this.dewPoint = dewPoint;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(String relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getOb() {
        return ob;
    }

    public void setOb(String ob) {
        this.ob = ob;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getPressureAltimeter() {
        return pressureAltimeter;
    }

    public void setPressureAltimeter(String pressureAltimeter) {
        this.pressureAltimeter = pressureAltimeter;
    }

    public String getSkyConditions() {
        return skyConditions;
    }

    public void setSkyConditions(String skyConditions) {
        this.skyConditions = skyConditions;
    }
}
