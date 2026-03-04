package com.NextLevel.USA.DTO0.Response;

import com.NextLevel.USA.DTO0.request.o.Cart.AddToCartDTO;

import java.util.List;


public class CartResponseDTO {
    private Long cartId;
    private String userEmail;
    private List<CartItemResponseDTO> items;
    private Double subtotal;
    private Double totalAmount;

    public CartResponseDTO(Long cartId, String userEmail, List<CartItemResponseDTO> items, Double subtotal, Double totalAmount) {
        this.cartId = cartId;
        this.userEmail = userEmail;
        this.items = items;
        this.subtotal = subtotal;
        this.totalAmount = totalAmount;
    }



    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<CartItemResponseDTO> getItems() {
        return items;
    }

    public void setItems(List<CartItemResponseDTO> items) {
        this.items = items;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
