package com.bortnichenko.weatherService.model;

import com.bortnichenko.weatherService.model.dtos.generalField.WeatherGeneralDto;
import com.bortnichenko.weatherService.model.dtos.OpenWeatherMainDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Vyacheslav Alekseevich
 * 04/08/2020
 */

public class OpenWeatherModel {

    private OpenWeatherMainDto main;
    @JsonProperty("weather")
    private List<WeatherGeneralDto> openWeatherDtoList;

    public OpenWeatherModel() {
    }

    public OpenWeatherMainDto getMain() {
        return main;
    }

    public void setMain(OpenWeatherMainDto main) {
        this.main = main;
    }

    public List<WeatherGeneralDto> getOpenWeatherDtoList() {
        return openWeatherDtoList;
    }

    public void setOpenWeatherDtoList(List<WeatherGeneralDto> openWeatherDtoList) {
        this.openWeatherDtoList = openWeatherDtoList;
    }

}
