package com.microserviceshouses.domain.utils.constants;

public enum SortByEnum {

    CITY("city"),
    CITY_DEPARTMENT("cityDepartment");

    private final String value;

    SortByEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    public static boolean isValid(String value) {
        for (SortByEnum sortBy : SortByEnum.values()) {
            if (sortBy.getValue().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}