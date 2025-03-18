package com.microserviceshouses.category.domain.utils.constants;

public final class DomainConstants {
    public static final int MAX_NAME_LENGTH = 50;

    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    /*
    Validation messages
     */
    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' can not be null";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' can not be null";
}
