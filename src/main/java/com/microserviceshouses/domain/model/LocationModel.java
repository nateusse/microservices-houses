package com.microserviceshouses.domain.model;

import com.microserviceshouses.domain.exceptions.LocationNeighborhoodMaxSizeExceededException;
import com.microserviceshouses.domain.utils.constants.DomainConstants;
import java.util.Objects;

public class LocationModel {

    private Long id;
    private String neighborhood;
    private Long cityId;
    private String cityName;
    private String departmentName;

    public LocationModel(Long id, String neighborhood, Long cityId, String cityName, String departmentName) {
        if (neighborhood.length() > 100) throw new LocationNeighborhoodMaxSizeExceededException();
        this.id = id;
        this.neighborhood = Objects.requireNonNull(neighborhood, DomainConstants.FIELD_NEIGHBORHOOD_NULL_MESSAGE);
        this.cityId = Objects.requireNonNull(cityId, DomainConstants.FIELD_CITY_ID_NULL_MESSAGE);
        this.cityName = cityName;
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        if (neighborhood.length() > 100) throw new LocationNeighborhoodMaxSizeExceededException();
        this.neighborhood = Objects.requireNonNull(neighborhood, DomainConstants.FIELD_NEIGHBORHOOD_NULL_MESSAGE);
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = Objects.requireNonNull(cityId, DomainConstants.FIELD_CITY_ID_NULL_MESSAGE);
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}