package com.microserviceshouses.infrastructure.exceptionshandler;

public class ExceptionConstants {

    private ExceptionConstants(){}

    public static final String NAME_MAX_SIZE_MESSAGE = "The name of the category can not exceed 50 characters";
    public static final String DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the category can not exceed 90 characters";
    public static final String CATEGORY_EXISTS_EXCEPTION = "The category already exists";
    public static final String CITY_DEPARTMENT_EXISTS_EXCEPTION = "The city department already exists";
    public static final String CITY_DEPARTMENT_NOT_EXISTS_EXCEPTION = "The city department not exists";
    public static final String CITY_NOT_EXISTS_EXCEPTION = "The city id not exists";
    public  static final String EMPTY_EXCEPTION = "The field must not be empty";
    public static final String SORT_BY_EXCEPTION = "The sort by field is not valid";
    public static final String GENERAL_EXCEPTION = "Server error";

}
