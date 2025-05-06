package com.microserviceshouses.infrastructure.endpoint.rest;


import com.microserviceshouses.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.application.dto.response.LocationResponse;
import com.microserviceshouses.application.dto.response.PaginationResponse;
import com.microserviceshouses.application.dto.response.SaveLocationResponse;
import com.microserviceshouses.application.services.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/")
    public ResponseEntity<SaveLocationResponse> save(@Valid @RequestBody SaveLocationRequest saveLocationRequest) {
        SaveLocationResponse save = locationService.save(saveLocationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping("/")
    public ResponseEntity<PaginationResponse<LocationResponse>> getLocationsFiltered(
            @RequestParam String name,
            @RequestParam String sortBy,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "true") boolean orderAsc) {
        return ResponseEntity.ok(locationService.getLocationsFiltered(name,sortBy, orderAsc, page, size));
    }

}
