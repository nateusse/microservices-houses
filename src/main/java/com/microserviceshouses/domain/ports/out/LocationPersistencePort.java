package com.microserviceshouses.domain.ports.out;

import com.microserviceshouses.domain.model.LocationModel;

public interface LocationPersistencePort {
   void save(LocationModel locationModel);
   boolean existsBySectorAndCity(String sector, String cityName);

}
