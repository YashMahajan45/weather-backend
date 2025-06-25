package com.example.weatherapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "https://gorgeous-valkyrie-f267cc.netlify.app") // Allow frontend
@RestController
@RequestMapping("/api")
public class WeatherController {

    @Value("${weather.api.key}")
    private String apiKey;

    @GetMapping("/weather")
    public ResponseEntity<String> getWeather(@RequestParam String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + ",IN&appid=" + apiKey + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();
        try {
            String response = restTemplate.getForObject(url, String.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("City not found or error fetching weather.");
        }
    }

    @GetMapping("/forecast")
    public ResponseEntity<String> getForecast(@RequestParam String city) {
        String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + ",IN&appid=" + apiKey + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();
        try {
            String response = restTemplate.getForObject(url, String.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("City not found or error fetching forecast.");
        }
    }
}
