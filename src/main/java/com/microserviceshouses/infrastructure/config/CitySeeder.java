package com.microserviceshouses.infrastructure.config;

import com.microserviceshouses.infrastructure.entity.CityEntity;
import com.microserviceshouses.infrastructure.entity.DepartmentEntity;
import com.microserviceshouses.infrastructure.repositories.mysql.CityRepository;
import com.microserviceshouses.infrastructure.repositories.mysql.DepartmentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CitySeeder {

    private final CityRepository cityRepository;
    private final DepartmentRepository departmentRepository;

    @PostConstruct
    public void seedCities() {
        addCity("Medellín", "Capital of Antioquia", "Antioquia");
        addCity("Bogotá", "Capital of Colombia", "Cundinamarca");
        addCity("Cali", "Capital of Valle del Cauca", "Valle del Cauca");
    }

    private void addCity(String cityName, String cityDesc, String deptName) {
        if (cityRepository.existsByName(cityName)) {
            System.out.println("City already exists: " + cityName);
            return;
        }


        DepartmentEntity department = departmentRepository.findByName(deptName)
                .orElseThrow(() -> new RuntimeException("Department not found: " + deptName));


        CityEntity city = new CityEntity();
        city.setName(cityName);
        city.setDescription(cityDesc);
        city.setDepartment(department);

        cityRepository.save(city);
        System.out.println("Saved city: " + cityName);
    }
}
