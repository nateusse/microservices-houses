package com.microserviceshouses.application.dto.request;

public record SearchLocationsRequest(
        String searchText,
        String orderBy,
        boolean ascending,
        int page,
        int size
) {}

