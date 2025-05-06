package com.microserviceshouses.application.services;

import com.microserviceshouses.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.application.dto.response.LocationResponse;
import com.microserviceshouses.application.dto.response.PaginationResponse;
import com.microserviceshouses.application.dto.response.SaveLocationResponse;

public interface LocationService {

    SaveLocationResponse save(SaveLocationRequest saveLocationRequest);
    PaginationResponse<LocationResponse> getLocationsFiltered(String name, String sortBy, boolean orderAsc, int page, int size);
}
