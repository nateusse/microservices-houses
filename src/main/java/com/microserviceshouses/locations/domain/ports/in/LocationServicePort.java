package com.microserviceshouses.locations.domain.ports.in;


import com.microserviceshouses.locations.domain.model.LocationModel;


public interface LocationServicePort {
    void save(LocationModel locationModel);

}
