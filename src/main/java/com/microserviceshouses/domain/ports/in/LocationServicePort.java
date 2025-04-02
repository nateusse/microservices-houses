package com.microserviceshouses.domain.ports.in;


import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.model.LocationModel;

import java.util.List;


public interface LocationServicePort {
    void save(LocationModel locationModel);
    List<CategoryModel> getLocations(Integer page, Integer size, boolean orderAsc);
}


