package com.NextLevel.USA.Mapper;

import com.NextLevel.USA.DTO0.Response.CartItemResponseDTO;
import com.NextLevel.USA.ENTITIES.CartItems;

public class CartMapper {

    public static CartItemResponseDTO mapItem(CartItems item) {

        double price = item.getProduct().getPrice().doubleValue();
        double total = price * item.getQuantity();

        return new CartItemResponseDTO(
                item.getProduct().getId(),
                item.getProduct().getName(),
                price,
                item.getQuantity(),
                total
        );
    }
}
