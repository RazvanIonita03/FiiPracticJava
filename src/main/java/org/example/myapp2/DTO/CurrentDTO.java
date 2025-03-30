package org.example.myapp2.DTO;

import lombok.Data;

@Data
public class CurrentDTO {
    private double temp_c;
    private double wind_kph;
    private String wind_dir;
    private double precip_mm;
}
