package com.NextLevel.USA.Services;

import com.NextLevel.USA.DTO0.Response.ProductResponseDTO;
import com.NextLevel.USA.DTO0.request.o.product.ProductCreateDTO;
import com.NextLevel.USA.DTO0.request.o.product.ProductUpdateDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO createProduct(ProductCreateDTO dto);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProductById(Long id);

    void deleteProduct(Long id);

    ProductResponseDTO updateProduct(Long id, ProductUpdateDTO dto);
}
