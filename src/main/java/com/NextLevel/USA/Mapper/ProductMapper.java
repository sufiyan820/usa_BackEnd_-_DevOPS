package com.NextLevel.USA.Mapper;

import com.NextLevel.USA.DTO0.request.o.product.ProductCreateDTO;
import com.NextLevel.USA.DTO0.request.o.product.ProductUpdateDTO;
import com.NextLevel.USA.DTO0.Response.ProductResponseDTO;
import com.NextLevel.USA.ENTITIES.Products;
import com.NextLevel.USA.Enum.ProductStatus;

public class ProductMapper {

    // Convert Entity -> ResponseDTO
    public static ProductResponseDTO toDTO(Products product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory(),
                product.getStock(),
                product.isAvailable(),
                product.getStatus()

        );
    }

    // Convert CreateDTO -> Entity
    public static Products toEntity(ProductCreateDTO dto) {

        Products product = new Products();

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());

        product.setAvailable(dto.getStock() > 0);

        if (dto.getStock() <= 0) {
            product.setStatus(ProductStatus.OUT_OF_STOCK);
        } else {
            product.setStatus(ProductStatus.ACTIVE);
        }

        return product;
    }

    // Update existing entity using UpdateDTO
    public static void updateEntity(Products product, ProductUpdateDTO dto) {

        if (dto.getName() != null)
            product.setName(dto.getName());

        if (dto.getDescription() != null)
            product.setDescription(dto.getDescription());

        if (dto.getCategory() != null)
            product.setCategory(dto.getCategory());

        if (dto.getPrice() != null)
            product.setPrice(dto.getPrice());

        if (dto.getStock() != null) {
            product.setStock(dto.getStock());
            product.setAvailable(dto.getStock() > 0);

            if (dto.getStock() <= 0) {
                product.setStatus(ProductStatus.OUT_OF_STOCK);
            } else {
                product.setStatus(ProductStatus.ACTIVE);
            }
        }

        if (dto.getStatus() != null)
            product.setStatus(dto.getStatus());
    }
}
