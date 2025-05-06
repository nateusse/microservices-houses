package com.microserviceshouses.domain.ports.in;


import com.microserviceshouses.domain.model.LocationModel;
import com.microserviceshouses.domain.model.pagination.PaginationResponseModel;

public interface LocationServicePort {

    void save(LocationModel locationModel);


}
