package com.microserviceshouses.domain.ports.in;


import com.microserviceshouses.domain.model.CityModel;

public interface CityServicePort {
    void save(CityModel cityModel);
}
