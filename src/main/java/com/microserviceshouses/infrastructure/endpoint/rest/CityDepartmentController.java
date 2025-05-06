package com.microserviceshouses.infrastructure.endpoint.rest;

import com.microserviceshouses.application.dto.request.SaveCityDepartmentRequest;
import com.microserviceshouses.application.dto.response.SaveCityDepartmentResponse;
import com.microserviceshouses.application.services.CityDepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/city-department")
@RequiredArgsConstructor
public class CityDepartmentController {

    private final CityDepartmentService cityDepartmentService;

    @PostMapping("/")
    public ResponseEntity<SaveCityDepartmentResponse> save(@Valid @RequestBody SaveCityDepartmentRequest saveCityDepartmentRequest) {
        SaveCityDepartmentResponse save = cityDepartmentService.save(saveCityDepartmentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

}