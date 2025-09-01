package com.hotelratingsystem.UserService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean(name = "appRestClient")
    public RestTemplate restTemplate(){
         return new RestTemplate();
    }

}
