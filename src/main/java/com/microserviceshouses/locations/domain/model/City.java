package com.microserviceshouses.locations.domain.model;


public record City(String name, String description) {
    public City {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("type something, lazy");
        }
        if (name.length() > 50) {
            throw new IllegalArgumentException("More than 50 words? not an essay");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("type something, lazy");
        }
        if (description.length() > 120) {
            throw new IllegalArgumentException("More than 120 words? not an essay");
        }
    }
}
