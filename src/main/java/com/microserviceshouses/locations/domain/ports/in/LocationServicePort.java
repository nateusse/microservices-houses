package com.microserviceshouses.locations.domain.ports.in;

import com.microserviceshouses.category.domain.model.CategoryModel;
import com.microserviceshouses.locations.domain.model.LocationModel;
import com.microserviceshouses.locations.domain.ports.out.LocationPersistencePort;
import com.microserviceshouses.locations.domain.usecases.LocationUseCase;

public interface LocationServicePort {
    void save(LocationModel locationModel);

}
