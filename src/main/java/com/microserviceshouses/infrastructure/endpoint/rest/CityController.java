package com.microserviceshouses.infrastructure.endpoint.rest;

import com.microserviceshouses.application.dto.request.SaveCityRequest;
import com.microserviceshouses.application.dto.response.SaveCityResponse;
import com.microserviceshouses.application.services.CityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping("/")
    public ResponseEntity<SaveCityResponse> save(@Valid @RequestBody SaveCityRequest saveCityRequest) {
        SaveCityResponse save = cityService.save(saveCityRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
}