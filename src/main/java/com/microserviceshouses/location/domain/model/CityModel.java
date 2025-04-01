package com.microserviceshouses.location.domain.model;

public class CityModel {
    private Long id;
    private String cityName;
    private String cityDescription;

    public CityModel(Long id, String cityName, String cityDescription) {
        if (cityName == null || cityName.isBlank()) {
            throw new IllegalArgumentException("Not empty city name, lazy MTF");
        }
        if (cityName.length() > 50) {
            throw new IllegalArgumentException("No more than 50 words, not an essay");
        }
        if (cityDescription == null || cityDescription.isBlank()) {
            throw new IllegalArgumentException("Not empty deparment  description, lazy MTF");
        }
        if (cityDescription.length() > 120) {
            throw new IllegalArgumentException("Description too long, talk to a therapist");
        }

        this.id = id;
        this.cityName = cityName;
        this.cityDescription = cityDescription;
    }

    public Long getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityDescription() {
        return cityDescription;
    }
}
