package com.microserviceshouses.locations.application.dto.request;

public record SaveLocationRequest(
        String cityName,
        String cityDescription,
        String departmentName,
        String departmentDescription
) {}

