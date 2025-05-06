package com.microserviceshouses.domain.ports.out;


import com.microserviceshouses.domain.model.CityModel;
import java.util.List;

public interface CityPersistencePort {

    void save(CityModel cityModel);
    CityModel getCityById(Long id);
    List<CityModel> getCityByNameLike(String name);
}
