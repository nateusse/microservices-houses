package com.microserviceshouses.application.dto.request;

public record SaveLocationRequest(
        String sectorOrNeighborhood,
        String cityName,
        String cityDescription,
        String departmentName,
        String departmentDescription
) {}

