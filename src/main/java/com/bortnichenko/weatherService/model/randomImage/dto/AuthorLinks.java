package com.bortnichenko.weatherService.model.randomImage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Vyacheslav Alekseevich
 * 13/08/2020
 */

public class AuthorLinks {

    @JsonProperty("html")
    private String photoCopyright;

    public String getPhotoCopyright() {
        return photoCopyright;
    }

    public void setPhotoCopyright(String photoCopyright) {
        this.photoCopyright = photoCopyright;
    }

}
