package com.oneslip.planet;

import com.oneslip.planet.service.PlanetDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PlanetApplication {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public PlanetDataService dataService() {
        return new PlanetDataService();
    }

    public static void main(String[] args) {
        SpringApplication.run(PlanetApplication.class, args);
    }

}
