package com.microserviceshouses.domain.utils.constants;

public class TestConstants {

    public static final Long DEFAULT_ID = 1L;

    public static final String VALID_NAME = "Luxury";
    public static final String VALID_DESCRIPTION = "High-end property with premium finishes";

    public static final String LONG_NAME = "L".repeat(51); // > 50
    public static final String LONG_DESCRIPTION = "D".repeat(91); // > 90

    public static final String NAME_NULL_MESSAGE = "Name must not be null";
    public static final String DESCRIPTION_NULL_MESSAGE = "Description must not be null";
    public static final String NAME_TOO_LONG_MESSAGE = "Name must not exceed 50 characters";
    public static final String DESCRIPTION_TOO_LONG_MESSAGE = "Description must not exceed 90 characters";
}
