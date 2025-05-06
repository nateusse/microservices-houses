package com.microserviceshouses.domain.ports.out;


import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.domain.model.pagination.PaginationResponseModel;

public interface LocationPersistencePort {

    void save(LocationModel locationModel);
    PaginationResponseModel<LocationModel> findByCityNameOrDepartmentName(String name, String sortBy, boolean ascending, int page, int size);
}
