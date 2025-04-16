package com.microserviceshouses.infrastructure.endpoint.rest;

import com.microserviceshouses.application.dto.request.SaveCityRequest;
import com.microserviceshouses.application.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public ResponseEntity<String> addCity(@RequestBody SaveCityRequest request) {
        cityService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("City saved");
    }


}
