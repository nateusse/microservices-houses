package com.microserviceshouses.infrastructure.exceptionshandler;

import com.microserviceshouses.domain.exceptions.DepartmentNameAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(DepartmentNameAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleDepartmentAlreadyExistsException(DepartmentNameAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DEPARTMENT_EXISTS_EXCEPTION,
                LocalDateTime.now()));
    }
}
