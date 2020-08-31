package com.bortnichenko.weatherService.controller;

import com.bortnichenko.weatherService.model.WeatherBitModel;
import com.bortnichenko.weatherService.model.randomImage.RandomImageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * Vyacheslav Alekseevich
 * 04/08/2020
 */

@Controller
public class WeatherController {

    // weather info
    private String citySearch;
    private String temp;
    private String weatherDesc;
    private String icon;
    private String humidity;
    private String clouds;
    private String windSpeed;

    // photo and BG color
    //photographer link
    private String photographLink;

    // bg image link
    private String imageUrlBG;

    // bg color (RGBA)
    private String rgbaColor;
    // body BG color
    private String rgbaBodyColor;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String openWeather(Model model) {

        // insert to left card
        model.addAttribute("temp", Objects.requireNonNullElse(temp, "-12"));
        model.addAttribute("city", Objects.requireNonNullElse(citySearch, "SaintP"));
        model.addAttribute("weatherDesc", Objects.requireNonNullElse(weatherDesc, "Rain"));
        model.addAttribute("icon", Objects.requireNonNullElse(icon, "/img/weather-icon/c03n.png"));

        // insert to right card
        model.addAttribute("cloudy", Objects.requireNonNullElse(clouds, "100%"));
        model.addAttribute("humidity", Objects.requireNonNullElse(humidity, "100%"));
        model.addAttribute("windSpeed", Objects.requireNonNullElse(windSpeed, "20 km/h"));

        // link on author
        model.addAttribute("photographLink", Objects.requireNonNullElse(photographLink, getImageUnsplash("unsplash.com")));

        // random BG image
        model.addAttribute("imageUrlBG", Objects.requireNonNullElse(imageUrlBG, getImageUnsplash("Rain")));

        // bg color
        model.addAttribute("color", Objects.requireNonNullElse(rgbaColor, getImageUnsplash("58, 140, 136, 0.5")));

        // body gradient color
        model.addAttribute("bodyBGColor", Objects.requireNonNullElse(rgbaBodyColor, getImageUnsplash("(rgba(58, 140, 136), rgba(58, 140, 136))")));

        return "index";
    }

    @PostMapping("/")
    public String searchCity(@RequestParam(name = "citySearch") String citySearch, Model model) {

        final String url = "https://api.weatherbit.io/v2.0/current?city=" + citySearch + "&key=333b829a43f44f43ad71efc63d4a7166";
        try {
            WeatherBitModel weatherBitModel = restTemplate.getForObject(url, WeatherBitModel.class);

            this.citySearch = weatherBitModel.getWeatherBitDtoList().get(0).getCityName();
            temp = String.format("%.0f", weatherBitModel.getWeatherBitDtoList().get(0).getTemp());
            humidity = String.format("%d%c", weatherBitModel.getWeatherBitDtoList().get(0).getHumidity(), '%');
            clouds = String.format("%s%c", weatherBitModel.getWeatherBitDtoList().get(0).getClouds(), '%');
            windSpeed = String.format("%.2f km/h", weatherBitModel.getWeatherBitDtoList().get(0).getWindSpeed());
            icon = String.format("/img/weather-icon/%s.png", weatherBitModel.getWeatherBitDtoList().get(0).getWeatherDtoList().getIcon());
            weatherDesc = weatherBitModel.getWeatherBitDtoList().get(0).getWeatherDtoList().getDescription();

            imageUrlBG = getImageUnsplash(weatherDesc);
            System.out.println(imageUrlBG);

        } catch (HttpClientErrorException | NullPointerException e) {
            System.out.println("error");
        } finally {
            // insert to left card
            model.addAttribute("temp", Objects.requireNonNullElse(temp, "-12"));
            model.addAttribute("city", Objects.requireNonNullElse(this.citySearch, "SaintP"));
            model.addAttribute("weatherDesc", Objects.requireNonNullElse(weatherDesc, "Rain"));
            model.addAttribute("icon", Objects.requireNonNullElse(icon, "/img/weather-icon/c03n.png"));

            // insert to right card
            model.addAttribute("cloudy", Objects.requireNonNullElse(clouds, "100%"));
            model.addAttribute("humidity", Objects.requireNonNullElse(humidity, "100%"));
            model.addAttribute("windSpeed", Objects.requireNonNullElse(windSpeed, "20 km/h"));

            // link on author
            model.addAttribute("photographLink", Objects.requireNonNullElse(photographLink, getImageUnsplash("unsplash.com")));

            model.addAttribute("imageUrlBG", Objects.requireNonNullElse(imageUrlBG, getImageUnsplash("depression Rain")));

            // weather card color
            model.addAttribute("color", Objects.requireNonNullElse(rgbaColor, getImageUnsplash("58, 140, 136, 0.5")));

            // body gradient color
            model.addAttribute("bodyBGColor", Objects.requireNonNullElse(rgbaBodyColor, getImageUnsplash("(rgba(93, 194, 189), rgba(93, 194, 189))")));

        }

        return "index";
    }

    private String getImageUnsplash(String weatherIs) {
        String olderUrl = "https://images.unsplash.com/photo-1523793740499-83d43b75a2b5?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjE1NTMyNH0";
        try {
            final String url = "https://api.unsplash.com/photos/random?query=" + weatherIs + "&client_id=2YSOWVB61-NgtVWuSoew5I9O4BzOTgi0642MPSCWXIY&orientation=landscape";
            RandomImageModel randomImageModel = restTemplate.getForObject(url, RandomImageModel.class);


            assert randomImageModel != null;
            rgbaColor = parseColor(randomImageModel.getColor());

            photographLink = randomImageModel.getPhotographerLink().getPhotoCopyright();

            olderUrl = randomImageModel.getImgUrlsList().getRegularUrlString();
            return olderUrl;
        } catch (HttpClientErrorException e) {
            return olderUrl;
        }
    }

    private String parseColor(String hexColor) {
        int[] color = new int[3];
        color[0] = Integer.valueOf(hexColor.substring(1, 3), 16);
        color[1] = Integer.valueOf(hexColor.substring(3, 5), 16);
        color[2] = Integer.valueOf(hexColor.substring(5, 7), 16);

        if (color[0] >= 20) {
            rgbaBodyColor = String.format("rgb(%d, %d, %d), rgb(%d, %d, %d)", color[0], color[1], color[2], (color[0] - 20), color[1], color[2]);
        } else {
            rgbaBodyColor = String.format("rgb(%d, %d, %d), rgb(%d, %d, %d)", color[0], color[1], color[2], color[0], color[1], color[2]);
        }

        return String.format("%d, %d, %d, 0.5", color[0], color[1], color[2]);
    }


}
