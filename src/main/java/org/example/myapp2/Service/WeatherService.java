package org.example.myapp2.Service;

import org.example.myapp2.DTO.CurrentDTO;
import org.example.myapp2.DTO.LocationDTO;
import org.example.myapp2.DTO.ResponseDTO;
import org.example.myapp2.Model.User;
import org.example.myapp2.Repository.WeatherRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class WeatherService {

    private WeatherRepository weatherRepository;
    private WebClient webClient;

    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://api.weatherapi.com/v1").build();
    }
    public User saveUser (User user) {
        return weatherRepository.save(user);
    }

    public ResponseDTO giveInfo(Double lat, Double lon) {
        String url = "/current.json?key=de5a1bc1c8fb4bbba4194622252203&q=" 
        + lat + "," 
        + lon + "&aqi=yes";

        JsonNode response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();
        LocationDTO location = new LocationDTO();
        location.setName(response.path("location").path("name").asText());
        location.setRegion(response.path("location").path("region").asText());
        location.setCountry(response.path("location").path("country").asText());
        location.setTz_id(response.path("location").path("tz_id").asText());
        CurrentDTO current = new CurrentDTO();
        current.setTemp_c(response.path("current").path("temp_c").asDouble());
        current.setWind_kph(response.path("current").path("wind_kph").asDouble());
        current.setWind_dir(response.path("current").path("wind_dir").asText());
        current.setPrecip_mm(response.path("current").path("precip_mm").asDouble());
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setLocation(location);
        responseDTO.setCurrent(current);
        
        return responseDTO;

    }

}
