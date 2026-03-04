package com.NextLevel.USA.Services;

import com.NextLevel.USA.DTO0.Response.CartItemResponseDTO;
import com.NextLevel.USA.DTO0.Response.CartResponseDTO;
import com.NextLevel.USA.DTO0.request.o.Cart.AddToCartDTO;
import com.NextLevel.USA.ENTITIES.Cart;
import com.NextLevel.USA.ENTITIES.CartItems;

public interface CartServices {

    CartResponseDTO getMyCart(String userEmail);

     CartResponseDTO addToCart(String userEmail, AddToCartDTO dto);

    CartResponseDTO updateQuantity(String userEmail, Long productId, Integer quantity);

    void removeItem(String userEmail, Long productId);

    void clearCart(String userEmail);
}
