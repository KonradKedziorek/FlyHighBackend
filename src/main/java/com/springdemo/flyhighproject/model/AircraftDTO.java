package com.springdemo.flyhighproject.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AircraftDTO {
    private String iata_code;
    private String id;
    private String name;

    public AircraftDTO(String iata_code, String id, String name) {
        this.iata_code = iata_code;
        this.id = id;
        this.name = name;
    }

    public String getIata_code() {
        return iata_code;
    }

    public void setIata_code(String iata_code) {
        this.iata_code = iata_code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
