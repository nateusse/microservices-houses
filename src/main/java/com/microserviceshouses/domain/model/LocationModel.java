package com.microserviceshouses.domain.model;

import java.util.Objects;
import java.util.UUID;

import static com.microserviceshouses.domain.utils.validations.Validation.validateName;

public class LocationModel {

    private UUID id;
    private String sectorOrNeighborhood;
    private CityModel city;

    public LocationModel(UUID id, String sectorOrNeighborhood, CityModel city) {
        this.sectorOrNeighborhood = validateName(sectorOrNeighborhood, "Location sector", 50);
        this.city = Objects.requireNonNull(city, "Location must belong to a city");
        this.id = id;
    }

    public void setSectorOrNeighborhood(String sectorOrNeighborhood) {
        this.sectorOrNeighborhood = validateName(sectorOrNeighborhood, "Location sector", 50);
    }

    public void setCity(CityModel city) {
        this.city = Objects.requireNonNull(city, "Location must belong to a city");
    }

    public UUID getId() {
        return id;
    }

    public String getSectorOrNeighborhood() {
        return sectorOrNeighborhood;
    }

    public CityModel getCity() {
        return city;
    }
}
