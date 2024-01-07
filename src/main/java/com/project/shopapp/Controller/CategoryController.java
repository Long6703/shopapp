package com.project.shopapp.Controller;

import com.project.shopapp.DTO.DTOcategory;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @GetMapping("")
    public ResponseEntity<String> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok("chao long" + page + " " + limit);
    }

    @PostMapping("")
    public ResponseEntity<?> insertCategory(@RequestBody @Valid DTOcategory dtocategory, BindingResult result){
        if(result.hasErrors()){
            List<String> errormessage = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
            return ResponseEntity.badRequest().body(errormessage);
        }
        return ResponseEntity.ok("This is insert category " + dtocategory.getName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id){
        return ResponseEntity.ok("this is put " + id);
    }



}
