package com.microserviceshouses.application.dto.response;

import java.util.List;

public record PaginationResponse<T>(
        List<T> content,
        int totalPages,
        int totalElements
) {}