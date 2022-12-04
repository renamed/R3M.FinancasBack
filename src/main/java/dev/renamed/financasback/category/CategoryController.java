package dev.renamed.financasback.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
//@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    Iterable<Category> all() {
        return categoryRepository.findAll();
    }

//    @GetMapping("/")
//    public Iterable<Category> findAllCategories() {
//        return categoryRepository.findAll();
//    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Category> findCategoryById(@PathVariable(value = "id") UUID id) {
//        Optional<Category> category = categoryRepository.findById(id);
//
//        return category.isPresent()
//                ? ResponseEntity.ok().body(category.get())
//                : ResponseEntity.notFound().build();
//    }
//
//    @PostMapping
//    public Category saveUser(@RequestBody Category category) {
//        return categoryRepository.save(category);
//    }

}
