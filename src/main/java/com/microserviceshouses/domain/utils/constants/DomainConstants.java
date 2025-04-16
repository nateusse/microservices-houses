package com.microserviceshouses.domain.utils.constants;

public final class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final int CATEGORY_NAME_MAX_LENGTH = 50;
    public static final int CATEGORY_DESCRIPTION_MAX_LENGTH= 50;
    public static final int LOCATION_NAME_MAX_LENGTH = 50;
    public static final int LOCATION_DESCRIPTION_MAX_LENGTH= 120;

    public static final String FIELD_NAME_NULL_MESSAGE = "Name must not be null";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Description must not be null";
}
