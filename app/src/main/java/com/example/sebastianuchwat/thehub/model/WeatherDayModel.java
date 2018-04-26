package com.example.sebastianuchwat.thehub.model;

import java.util.Map;

/**
 * Created by sebastianuchwat on 03/02/2018.
 */

public class WeatherDayModel {

    private String mDay;
    private String mWeatherShort;
    private String mIcon;

    public WeatherDayModel(String day, String weatherShort, String icon) {
        this.mDay = day;
        this.mWeatherShort = weatherShort;
        this.mIcon = icon;

    }

    public String getmDay() {
        return mDay;
    }

    public String getmWeatherShort() { return mWeatherShort; }

    public String getmIcon() { return mIcon; }

}
