package com.microserviceshouses.locations.domain.ports.out;

import com.microserviceshouses.locations.domain.model.LocationModel;

public interface LocationPersistencePort {
    void save(LocationModel locationModel);  // Guardar ubicación

}
