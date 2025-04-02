package com.microserviceshouses.domain.ports.in;


import com.microserviceshouses.domain.model.LocationModel;


public interface LocationServicePort {
    void save(LocationModel locationModel);
}


