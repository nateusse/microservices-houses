package com.microserviceshouses.application.services;

import com.microserviceshouses.application.dto.request.SaveCityRequest;
import com.microserviceshouses.application.dto.response.SaveCityResponse;


public interface CityService {
    SaveCityResponse save(SaveCityRequest request);

}
