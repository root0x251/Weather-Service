package com.bortnichenko.weatherService.model.dtos;

import com.bortnichenko.weatherService.model.dtos.generalField.WeatherGeneralDto;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Vyacheslav Alekseevich
 * 04/08/2020
 */

public class WeatherBitDto {

    @JsonProperty("wind_cdir_full")
    private String windFull;

    @JsonProperty("temp")
    private float temp;

    @JsonProperty("city_name")
    private String city;

    @JsonProperty("weather")
    private WeatherGeneralDto weatherDtoList;



    public WeatherBitDto() {
    }

    public String getWindFull() {
        return windFull;
    }

    public void setWindFull(String windFull) {
        this.windFull = windFull;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setWeatherDtoList(WeatherGeneralDto weatherDtoList) {
        this.weatherDtoList = weatherDtoList;
    }
}
