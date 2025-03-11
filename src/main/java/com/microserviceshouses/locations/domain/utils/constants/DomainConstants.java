package com.microserviceshouses.locations.domain.utils.constants;


public final class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    /*
    Validation messages
     */


    public static final int MAX_NAME_LENGTH = 50;
    public static final int MAX_DESCRIPTION_LENGTH = 120;

    public static final String FIELD_NAME_NULL_MESSAGE = "Put some city, the keyboard has a lot of keys you greety asshole";
    public static final String FIELD_NAME_TOO_LONG_MESSAGE = "Holy shit that's long name, just " + MAX_NAME_LENGTH + " please";

    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Put some description, the keyboard has a lot of keys you greety asshole";
    public static final String FIELD_DESCRIPTION_TOO_LONG_MESSAGE = "Holy shit that's long description " + MAX_DESCRIPTION_LENGTH + " please";


}
