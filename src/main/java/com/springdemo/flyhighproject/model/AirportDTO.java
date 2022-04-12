package com.springdemo.flyhighproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;


@NoArgsConstructor
@Getter
@Setter
public class AirportDTO {
    private String time_zone;
    private String name;
    private Double longitude;
    private Double latitude;
    private String id;
    private String icao_code;
    private String iata_country_code;
    private String iata_code;
    private String city_name;
    private String city;

    public AirportDTO(String time_zone, String name, Double longitude, Double latitude, String id,  String iata_country_code, String iata_code, String city_name){
        this.time_zone = time_zone;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.id = id;
        this.iata_country_code = iata_country_code;
        this.iata_code = iata_code;
        this.city_name = city_name;
    }

    public AirportDTO(String time_zone, String name, Double longitude, Double latitude, String id, String icao_code, String iata_country_code, String iata_code, String city_name){
        this.time_zone = time_zone;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.id = id;
        this.icao_code = icao_code;
        this.iata_country_code = iata_country_code;
        this.iata_code = iata_code;
        this.city_name = city_name;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcao_code() {
        return icao_code;
    }

    public void setIcao_code(String icao_code) {
        this.icao_code = icao_code;
    }

    public String getIata_country_code() {
        return iata_country_code;
    }

    public void setIata_country_code(String iata_country_code) {
        this.iata_country_code = iata_country_code;
    }

    public String getIata_code() {
        return iata_code;
    }

    public void setIata_code(String iata_code) {
        this.iata_code = iata_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
