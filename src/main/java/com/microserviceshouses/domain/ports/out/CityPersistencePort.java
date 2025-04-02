package com.microserviceshouses.domain.ports.out;

import com.microserviceshouses.domain.model.CityModel;



public interface CityPersistencePort {
    void save(CityModel cityModel);

}
