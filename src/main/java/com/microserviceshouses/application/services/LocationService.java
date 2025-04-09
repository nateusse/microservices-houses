package com.microserviceshouses.application.services;

import com.microserviceshouses.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.application.dto.response.LocationResponse;
import com.microserviceshouses.application.dto.response.SaveLocationResponse;

import java.util.List;

public interface LocationService {

    SaveLocationResponse save(SaveLocationRequest request);
    List<LocationResponse> searchLocations(String text, String orderBy, boolean ascending, int page, int size);
}
