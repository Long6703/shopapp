package com.project.shopapp.Controller;

import com.project.shopapp.DTO.productDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @GetMapping("")
    public ResponseEntity<String> getProducts(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit) {
        return ResponseEntity.ok("get Products here");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductsById(
        @PathVariable("id") String productId
    ){
        return ResponseEntity.ok("Get product by ID : " + productId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductByID(
            @PathVariable("id") String productId
    ){
        return ResponseEntity.ok("Delete product by Id : " + productId);
    }

    @PostMapping("")
    public ResponseEntity<?> createProduct(
            @Valid @RequestBody productDTO productDTO,
            BindingResult result){
        try {
            if(result.hasErrors()){
                List<String> errormessage = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.badRequest().body(errormessage);
            }
            return ResponseEntity.ok("Product create successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
