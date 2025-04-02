package com.microserviceshouses.domain.ports.in;


import com.microserviceshouses.domain.model.CityModel;

import java.util.List;

public interface CityServicePort {
    void save(CityModel cityModel);
    List<CityModel> getCities();

}
