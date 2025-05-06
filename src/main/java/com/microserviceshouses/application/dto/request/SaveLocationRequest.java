package com.microserviceshouses.application.dto.request;

public record SaveLocationRequest
        (String neighborhood,
         Long   cityId) {
}

