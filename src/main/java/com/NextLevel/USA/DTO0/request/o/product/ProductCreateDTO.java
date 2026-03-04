package com.NextLevel.USA.DTO0.request.o.product;


import com.NextLevel.USA.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateDTO {
    private Long id;
    private String name;
    private int stock;
    private String description;
    private BigDecimal Price;
    private String category;
    private ProductStatus status;
    private String manufacturer;

}
