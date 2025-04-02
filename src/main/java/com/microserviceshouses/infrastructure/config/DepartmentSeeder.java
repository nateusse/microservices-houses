package com.microserviceshouses.infrastructure.config;

import com.microserviceshouses.domain.model.DepartmentModel;
import com.microserviceshouses.domain.ports.in.DepartmentServicePort;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartmentSeeder {

    private final DepartmentServicePort departmentServicePort;

    @PostConstruct
    public void seedDepartments() {
        List<DepartmentModel> departments = List.of(
                new DepartmentModel(null, "Antioquia", "Mountainous department with Medellín as its capital."),
                new DepartmentModel(null, "Cundinamarca", "Department in central Colombia with Bogotá as capital."),
                new DepartmentModel(null, "Valle del Cauca", "Pacific region, capital is Cali, home to Buenaventura.")
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
