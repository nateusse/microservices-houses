package com.microserviceshouses.application.services;


import com.microserviceshouses.application.dto.request.SaveCityDepartmentRequest;
import com.microserviceshouses.application.dto.response.SaveCityDepartmentResponse;

public interface CityDepartmentService {
    SaveCityDepartmentResponse save(SaveCityDepartmentRequest saveCityDepartmentRequest);

}