package com.microserviceshouses.infrastructure.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cities")
public class CityEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 120, nullable = false)
    private String description;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentEntity department;
}