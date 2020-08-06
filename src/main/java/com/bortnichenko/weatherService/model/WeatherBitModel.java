package com.bortnichenko.weatherService.model;

import com.bortnichenko.weatherService.model.dtos.WeatherBitDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Vyacheslav Alekseevich
 * 04/08/2020
 */

public class WeatherBitModel {

    @JsonProperty("data")
    private List<WeatherBitDto> weatherBitDtoList;

    public WeatherBitModel() {
    }

    public List<WeatherBitDto> getWeatherBitDtoList() {
        return weatherBitDtoList;
    }

    public void setWeatherBitDtoList(List<WeatherBitDto> weatherBitDtoList) {
        this.weatherBitDtoList = weatherBitDtoList;
    }
}
