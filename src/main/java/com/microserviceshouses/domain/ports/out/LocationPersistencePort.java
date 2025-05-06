package com.microserviceshouses.domain.ports.out;


import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.domain.model.pagination.PaginationResponseModel;

public interface LocationPersistencePort {

    void save(LocationModel locationModel);

}
