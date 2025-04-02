package com.microserviceshouses.infrastructure.endpoint.rest;


import com.microserviceshouses.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.application.dto.response.SaveLocationResponse;
import com.microserviceshouses.application.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<SaveLocationResponse> create(@RequestBody SaveLocationRequest request) {
        SaveLocationResponse response = locationService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}