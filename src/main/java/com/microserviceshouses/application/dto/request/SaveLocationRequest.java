package com.microserviceshouses.application.dto.request;

public record SaveLocationRequest(
        String sectorOrNeighborhood,
        Long cityId
) {}

