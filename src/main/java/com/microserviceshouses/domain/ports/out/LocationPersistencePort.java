package com.microserviceshouses.domain.ports.out;

import com.microserviceshouses.domain.model.LocationModel;

import java.util.List;

public interface LocationPersistencePort {
   void save(LocationModel locationModel);
   boolean existsBySectorAndCity(String sector, String cityName);
   List<LocationModel> getLocations(Integer page, Integer size, boolean orderAsc);
   List<LocationModel> searchLocations(String text, String orderBy, boolean ascending, int page, int size);

}
