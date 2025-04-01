package com.microserviceshouses.location.application.dto.request;

public record SaveLocationRequest(
        String cityName,
        String cityDescription,
        String departmentName,
        String departmentDescription
) {}

