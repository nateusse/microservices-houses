package com.microserviceshouses.infrastructure.exceptionshandler;


import com.microserviceshouses.domain.exceptions.*;
import com.microserviceshouses.infrastructure.exceptions.DatabaseInfraestructureException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(CategoryNameMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleNameMaxSizeExceededException(CategoryNameMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.NAME_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    @ExceptionHandler(CategoryDescriptionMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionMaxSizeExceededException(CategoryDescriptionMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DESCRIPTION_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CATEGORY_EXISTS_EXCEPTION,
                LocalDateTime.now()));
    }

    @ExceptionHandler(CityDepartmentNameMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleCityDepartmentNameMaxSizeExceededException(CityDepartmentNameMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.NAME_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    @ExceptionHandler(CityDepartmentDescriptionMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleCityDepartmentDescriptionMaxSizeExceededException(CityDepartmentDescriptionMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DESCRIPTION_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    @ExceptionHandler(CityDepartmentAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleCityDepartmentAlreadyExist(CityDepartmentAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CITY_DEPARTMENT_EXISTS_EXCEPTION,
                LocalDateTime.now()));
    }

    @ExceptionHandler(CityDepartmentNotExist.class)
    public ResponseEntity<ExceptionResponse> handleCityDepartmentNotExist(CityDepartmentNotExist exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CITY_DEPARTMENT_NOT_EXISTS_EXCEPTION,
                LocalDateTime.now()));
    }

    @ExceptionHandler(CityNotExistException.class)
    public ResponseEntity<ExceptionResponse> handleCityNotExistException(CityNotExistException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CITY_NOT_EXISTS_EXCEPTION,
                LocalDateTime.now()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(new ExceptionResponse(errors.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleCityNotExistException(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.GENERAL_EXCEPTION,
                LocalDateTime.now()));
    }

    @ExceptionHandler(LocationSortByException.class)
    public ResponseEntity<ExceptionResponse> handleLocationSortByException(LocationSortByException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.SORT_BY_EXCEPTION,
                LocalDateTime.now()));
    }

    @ExceptionHandler(DatabaseInfraestructureException.class)
    public ResponseEntity<ExceptionResponse> handleDatabaseInfraestructureException(DatabaseInfraestructureException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.GENERAL_EXCEPTION,
                LocalDateTime.now()));
    }

}
