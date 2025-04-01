package com.microserviceshouses.location.infrastructure.endpoint.rest;

import com.microserviceshouses.location.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.location.domain.ports.in.LocationServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/locations")
@RequiredArgsConstructor
public class LocationController {


    //not calling Service directly as arquetype, I can change now UseCases and others without contrlelr
    //easy testing mock LocationServicePOrt
   // private final LocationServicePort locationServicePort;

    @PostMapping
    public ResponseEntity<Void> createLocation(@RequestBody SaveLocationRequest request) {
       // locationServicePort.saveLocation(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
