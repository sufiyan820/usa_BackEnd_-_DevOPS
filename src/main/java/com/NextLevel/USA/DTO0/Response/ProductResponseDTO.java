package com.NextLevel.USA.DTO0.Response;


import com.NextLevel.USA.Enum.ProductStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
 public class ProductResponseDTO {
    private  Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private Integer stock;
    private boolean available;
    private ProductStatus status;
    private String manufacturer;
    private List<String> imageUrls;


    public ProductResponseDTO(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public ProductResponseDTO(Long id, String name, String description, BigDecimal price, String category, Integer stock, boolean available, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.available = available;
        this.status = status;
        this.manufacturer = manufacturer;
    }
}
