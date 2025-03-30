package org.example.myapp2.DTO;

import lombok.Data;

@Data
public class LocationDTO {
    private String name;
    private String region;
    private String country;
    private String tz_id;
}
