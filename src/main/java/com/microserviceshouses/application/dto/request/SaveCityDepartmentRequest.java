package com.microserviceshouses.application.dto.request;

public record SaveCityDepartmentRequest (
        String name,
        String description) {
}