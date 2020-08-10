package com.bortnichenko.weatherService.controller;

import com.bortnichenko.weatherService.model.OpenWeatherModel;
import com.bortnichenko.weatherService.model.WeatherBitModel;
import com.bortnichenko.weatherService.model.randomImage.RandomImageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Vyacheslav Alekseevich
 * 04/08/2020
 */

@RestController
public class WeatherController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String openWeather() {
        final String url = "https://api.openweathermap.org/data/2.5/weather?q=Всеволожск&appid=da0ad9258489617eb671cc62e2fa42f0&lang=ru";
        try {
            OpenWeatherModel openWeatherModel = restTemplate.getForObject(url, OpenWeatherModel.class);

            System.out.println(openWeatherModel.getMain().getTemp());
            System.out.printf("%.2f \n", openWeatherModel.getMain().getTemp() - 273.15f);
            System.out.println(openWeatherModel.getOpenWeatherDtoList().get(0).getDescription());
            System.out.println(openWeatherModel.getOpenWeatherDtoList().get(0).getIcon());

        } catch (HttpClientErrorException e) {
            return "City not found";
        }

        return "";
    }

    @GetMapping("/qq")
    public String weatherBit() {
        final String url = "https://api.weatherbit.io/v2.0/current?city=Всеволожск&key=333b829a43f44f43ad71efc63d4a7166&lang=ru";

        WeatherBitModel weatherBitModel = restTemplate.getForObject(url, WeatherBitModel.class);

        System.out.println("======================");
        System.out.println(weatherBitModel.getWeatherBitDtoList().get(0).getTemp());
        System.out.println(weatherBitModel.getWeatherBitDtoList().get(0).getWeatherDtoList().getDescription());
        System.out.println(weatherBitModel.getWeatherBitDtoList().get(0).getWeatherDtoList().getIcon());
        System.out.println(weatherBitModel.getWeatherBitDtoList().get(0).getCity());
        System.out.println(weatherBitModel.getWeatherBitDtoList().get(0).getWindFull());

        return "";
    }

    @GetMapping("/img")
    private String getImageUnsplash() {
        final String url = "https://api.unsplash.com/photos/random?query=sunshine&client_id=2YSOWVB61-NgtVWuSoew5I9O4BzOTgi0642MPSCWXIY&orientation=landscape";
        RandomImageModel randomImageModel = restTemplate.getForObject(url, RandomImageModel.class);

        System.out.println(randomImageModel.getColor());
        System.out.println(randomImageModel.getDescription());
        System.out.println(randomImageModel.getAltDescription());
        System.out.println(randomImageModel.getImgUrlsList().getFullUrlString());
        System.out.println(randomImageModel.getImgUrlsList().getRegularUrlString());

        return "";
    }
}
