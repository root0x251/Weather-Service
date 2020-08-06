package com.bortnichenko.weatherService.model.dtos.generalField;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Vyacheslav Alekseevich
 * 04/08/2020
 */

public class WeatherGeneralDto {

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("description")
    private String description;


    public WeatherGeneralDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
