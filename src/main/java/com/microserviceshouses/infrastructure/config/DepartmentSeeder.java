package com.microserviceshouses.infrastructure.config;

import com.microserviceshouses.domain.model.DepartmentModel;
import com.microserviceshouses.domain.ports.in.DepartmentServicePort;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DepartmentSeeder {

    private final DepartmentServicePort departmentServicePort;

    @PostConstruct
    public void seedDepartments() {
        List<DepartmentModel> departments = List.of(
                new DepartmentModel(UUID.randomUUID(), "Antioquia", "Main department in Colombia"),
                new DepartmentModel(UUID.randomUUID(), "Cundinamarca", "Department surrounding Bogotá"),
                new DepartmentModel(UUID.randomUUID(), "Valle del Cauca", "Home of Cali and delicious food")
        );

        for (DepartmentModel dept : departments) {
            try {
                departmentServicePort.save(dept);
            } catch (RuntimeException e) {
                System.out.println("Department already exists: " + dept.getName());
            }
        }
    }
}