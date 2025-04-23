package com.microserviceshouses.infrastructure.endpoint.rest;

import com.microserviceshouses.application.dto.request.SaveCategoryRequest;
import com.microserviceshouses.application.dto.response.CategoryResponse;
import com.microserviceshouses.application.dto.response.PageDto;
import com.microserviceshouses.application.dto.response.SaveCategoryResponse;
import com.microserviceshouses.application.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<SaveCategoryResponse> save(@Valid @RequestBody SaveCategoryRequest saveCategoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(saveCategoryRequest));
    }

    @GetMapping
    public ResponseEntity<PageDto<CategoryResponse>> getCategories(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "true") boolean orderAsc
    ) {
        PageDto<CategoryResponse> response = categoryService.getCategories(name, page, size, orderAsc);
        return ResponseEntity.ok(response);
    }

}
