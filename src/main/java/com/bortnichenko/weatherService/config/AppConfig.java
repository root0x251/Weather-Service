package com.bortnichenko.weatherService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Vyacheslav Alekseevich
 * 04/08/2020
 */

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }

}
