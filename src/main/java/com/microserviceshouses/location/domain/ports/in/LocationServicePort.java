package com.microserviceshouses.location.domain.ports.in;

import com.microserviceshouses.category.domain.model.CategoryModel;
import com.microserviceshouses.location.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.location.domain.model.LocationModel;

import java.util.List;

public interface LocationServicePort {
    void saveLocation(LocationModel locationModel);
}


