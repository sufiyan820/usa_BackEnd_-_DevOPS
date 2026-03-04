package com.NextLevel.USA.DTO0.request.o.product;


import com.NextLevel.USA.Enum.ProductStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class ProductUpdateDTO {

    private Long id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Integer stock   ;
    private  String available;
    private ProductStatus status;
    private  String manufacturer;




}
