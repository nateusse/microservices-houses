package com.microserviceshouses.infrastructure.endpoint.rest;


import com.microserviceshouses.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.application.dto.response.LocationResponse;
import com.microserviceshouses.application.dto.response.SaveLocationResponse;
import com.microserviceshouses.application.services.LocationService;
import com.microserviceshouses.domain.model.LocationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/search")
    public ResponseEntity<List<LocationResponse>> searchLocations(
            @RequestParam String text,
            @RequestParam(defaultValue = "city") String orderBy,
            @RequestParam(defaultValue = "true") boolean ascending,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        List<LocationResponse> response = locationService.searchLocations(text, orderBy, ascending, page, size);
        return ResponseEntity.ok(response);
    }
}