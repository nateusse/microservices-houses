package com.microserviceshouses.domain.model;

import com.microserviceshouses.domain.model.CategoryModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microserviceshouses.domain.utils.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;


class CategoryModelTest {

    private Long id;
    private String name;
    private String description;

    @BeforeEach
    void setUp() {
        id = DEFAULT_ID;
        name = VALID_NAME;
        description = VALID_DESCRIPTION;
    }

    @Test
    void shouldCreateValidCategory() {
        CategoryModel category = new CategoryModel(id, name, description);
        assertEquals(name, category.getName());
        assertEquals(description, category.getDescription());
        assertEquals(id, category.getId());
    }

    @Test
    void shouldSetValidNameAndDescription() {
        CategoryModel category = new CategoryModel(id, name, description);
        category.setName("Affordable");
        category.setDescription("Budget-friendly property");
        assertEquals("Affordable", category.getName());
        assertEquals("Budget-friendly property", category.getDescription());
    }


    @Test
    void shouldThrowExceptionWhenNameIsTooLong() {
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                new CategoryModel(id, LONG_NAME, description)
        );
        assertEquals(NAME_TOO_LONG_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenDescriptionIsTooLong() {
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                new CategoryModel(id, name, LONG_DESCRIPTION)
        );
        assertEquals(DESCRIPTION_TOO_LONG_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () ->
                new CategoryModel(id, null, description)
        );
        assertEquals(NAME_NULL_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenDescriptionIsNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () ->
                new CategoryModel(id, name, null)
        );
        assertEquals(DESCRIPTION_NULL_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSettingTooLongName() {
        CategoryModel category = new CategoryModel(id, name, description);
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                category.setName(LONG_NAME)
        );
        assertEquals(NAME_TOO_LONG_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSettingTooLongDescription() {
        CategoryModel category = new CategoryModel(id, name, description);
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                category.setDescription(LONG_DESCRIPTION)
        );
        assertEquals(DESCRIPTION_TOO_LONG_MESSAGE, exception.getMessage());
    }
}

