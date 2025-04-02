package com.microserviceshouses.application.dto.response;



public record LocationResponse(
        Long id,
        String sectorOrNeighborhood,
        String cityName,
        String departmentName
) {}

