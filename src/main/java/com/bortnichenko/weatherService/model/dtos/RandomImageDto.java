package com.bortnichenko.weatherService.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Vyacheslav Alekseevich
 * 06/08/2020
 */

public class RandomImageDto {

    @JsonProperty("full")
    private String fullUrlString;
    @JsonProperty("regular")
    private String regularUrlString;

    public String getFullUrlString() {
        return fullUrlString;
    }

    public void setFullUrlString(String fullUrlString) {
        this.fullUrlString = fullUrlString;
    }

    public String getRegularUrlString() {
        return regularUrlString;
    }

    public void setRegularUrlString(String regularUrlString) {
        this.regularUrlString = regularUrlString;
    }
}
