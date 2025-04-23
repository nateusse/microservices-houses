package com.microserviceshouses.infrastructure.config;


import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.ports.out.CategoryPersistencePort;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CategorySeeder {

    private final CategoryPersistencePort categoryPersistencePort;

    public CategorySeeder(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @PostConstruct
    public void seedCategories() {
        seedIfNotExists("New", "Brand new property, ready to move in");
        seedIfNotExists("Used", "Previously owned property in good condition");
        seedIfNotExists("Luxury", "High-end property with premium finishes");
        seedIfNotExists("Affordable", "Budget-friendly property");
        seedIfNotExists("Residential", "Property intended for living purposes");
        seedIfNotExists("Commercial", "Shops, offices or bussiness");
        seedIfNotExists("Pet Friendly", "Suitable property for living with pets");
        seedIfNotExists("Furnished", "Includes furniture and ready to use");
    }

    private void seedIfNotExists(String name, String description) {
        if (!categoryPersistencePort.existsByName(name)) {
            categoryPersistencePort.save(new CategoryModel(null, name, description));
        }
    }
}
