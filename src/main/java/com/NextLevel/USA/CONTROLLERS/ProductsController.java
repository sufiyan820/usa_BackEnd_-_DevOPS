package com.NextLevel.USA.CONTROLLERS;

import com.NextLevel.USA.DTO0.request.o.product.ProductCreateDTO;
import com.NextLevel.USA.DTO0.request.o.product.ProductUpdateDTO;
import com.NextLevel.USA.DTO0.Response.ProductResponseDTO;
import com.NextLevel.USA.Services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    // ✅ CREATE PRODUCT
    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> createProduct(
            @RequestBody ProductCreateDTO dto) {

        ProductResponseDTO response = productService.createProduct(dto);
        return ResponseEntity.ok(response);
    }

    // ✅ UPDATE PRODUCT
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductUpdateDTO dto) {

        ProductResponseDTO response = productService.updateProduct(id, dto);
        return ResponseEntity.ok(response);
    }

    // ✅ GET PRODUCT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(
            @PathVariable Long id) {

        return ResponseEntity.ok(productService.getProductById(id));
    }

    // ✅ GET ALL PRODUCTS
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {

        return ResponseEntity.ok(productService.getAllProducts());
    }

    // ✅ DELETE PRODUCT
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable Long id) {

        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
