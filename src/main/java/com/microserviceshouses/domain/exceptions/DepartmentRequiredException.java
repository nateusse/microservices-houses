package com.microserviceshouses.domain.exceptions;

public class DepartmentRequiredException extends RuntimeException {
  public DepartmentRequiredException() {
    super("City must belong to a department");
  }
}
