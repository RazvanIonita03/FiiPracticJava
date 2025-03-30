package org.example.myapp2.Controller;

import org.example.myapp2.DTO.ResponseDTO;
import org.example.myapp2.Model.User;
import org.example.myapp2.Service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = weatherService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/details")
    public ResponseEntity<?> getWeatherDetails(@RequestParam(required = false) Double lat,
                                    @RequestParam(required = false) Double lon) {
        if(lat!=null && lon!=null){
            ResponseDTO weatherInfo = weatherService.giveInfo(lat, lon);
            return ResponseEntity.ok(weatherInfo);
        }
        return ResponseEntity.badRequest().body("Invalid location parameters!");
    }

}
