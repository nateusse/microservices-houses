package com.microserviceshouses.infrastructure.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "departments", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class DepartmentEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @Column(length = 120, nullable = false)
    private String description;


}