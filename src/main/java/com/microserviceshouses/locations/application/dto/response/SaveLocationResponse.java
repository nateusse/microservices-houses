package com.microserviceshouses.locations.application.dto.response;


public record SaveLocationResponse(
        Long id,
        String cityName,
        String departmentName,
        String message
){}
