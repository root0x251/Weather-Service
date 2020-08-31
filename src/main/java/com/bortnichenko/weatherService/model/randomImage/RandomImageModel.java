package com.bortnichenko.weatherService.model.randomImage;

import com.bortnichenko.weatherService.model.randomImage.dto.AuthorLinks;
import com.bortnichenko.weatherService.model.randomImage.dto.RandomImageDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Vyacheslav Alekseevich
 * 06/08/2020
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomImageModel {

    @JsonProperty("color")
    private String color;
    @JsonProperty("alt_description")
    private String altDescription;

    @JsonProperty("urls")
    private RandomImageDto imgUrlsList;

    @JsonProperty("links")
    private AuthorLinks photographerLink;

    public RandomImageModel() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAltDescription() {
        return altDescription;
    }

    public void setAltDescription(String altDescription) {
        this.altDescription = altDescription;
    }

    public RandomImageDto getImgUrlsList() {
        return imgUrlsList;
    }

    public void setImgUrlsList(RandomImageDto imgUrlsList) {
        this.imgUrlsList = imgUrlsList;
    }

    public AuthorLinks getPhotographerLink() {
        return photographerLink;
    }

    public void setPhotographerLink(AuthorLinks photographerLink) {
        this.photographerLink = photographerLink;
    }
}
