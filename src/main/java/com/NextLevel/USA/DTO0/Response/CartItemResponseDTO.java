package com.NextLevel.USA.DTO0.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CartItemResponseDTO {
    private Long productId;
    private String productName;
     private Double totalPrice;
    private Integer quantity;
    private Double price;

    public CartItemResponseDTO(Long productId, String productName, Double totalPrice, Integer quantity, Double price) {
        this.productId = productId;
        this.productName = productName;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
