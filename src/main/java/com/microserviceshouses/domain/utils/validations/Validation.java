package com.microserviceshouses.domain.utils.validations;


import java.util.Objects;

public class Validation {

    public static String validateName(String name, String label, int maxLength) {
        name = Objects.requireNonNull(name, label + " must not be null").trim();
        if (name.isEmpty()) throw new RuntimeException(label + " must not be empty");
        if (name.length() > maxLength) throw new RuntimeException(label + " must not exceed " + maxLength + " characters");
        return name;
    }

    public static String validateDescription(String description, String label, int maxLength) {
        description = Objects.requireNonNull(description, label + " must not be null").trim();
        if (description.isEmpty()) throw new RuntimeException(label + " must not be empty");
        if (description.length() > maxLength) throw new RuntimeException(label + " must not exceed " + maxLength + " characters");
        return description;
    }
}