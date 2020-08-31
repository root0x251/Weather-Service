package com.bortnichenko.weatherService.model.dtos;

import com.bortnichenko.weatherService.model.dtos.generalField.WeatherGeneralDto;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Vyacheslav Alekseevich
 * 04/08/2020
 */

public class WeatherBitDto {

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("rh")
    private int humidity;

    @JsonProperty("clouds")
    private String clouds;

    @JsonProperty("wind_spd")
    private float windSpeed;

    @JsonProperty("temp")
    private float temp;

    @JsonProperty("weather")
    private WeatherGeneralDto weatherDtoList;


    public WeatherBitDto() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public WeatherGeneralDto getWeatherDtoList() {
        return weatherDtoList;
    }

    public void setWeatherDtoList(WeatherGeneralDto weatherDtoList) {
        this.weatherDtoList = weatherDtoList;
    }
}
