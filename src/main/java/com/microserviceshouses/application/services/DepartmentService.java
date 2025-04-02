package com.microserviceshouses.application.services;

import com.microserviceshouses.application.dto.request.SaveDepartmentRequest;
import com.microserviceshouses.application.dto.response.DepartmentResponse;
import com.microserviceshouses.application.dto.response.SaveDepartmentResponse;

import java.util.List;



public interface DepartmentService {
    SaveDepartmentResponse save(SaveDepartmentRequest request);

}