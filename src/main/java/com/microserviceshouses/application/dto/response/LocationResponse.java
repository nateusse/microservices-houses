package com.microserviceshouses.application.dto.response;

import java.util.UUID;

public record LocationResponse(
        UUID id,
        String sectorOrNeighborhood,
        String cityName,
        String departmentName
) {}

