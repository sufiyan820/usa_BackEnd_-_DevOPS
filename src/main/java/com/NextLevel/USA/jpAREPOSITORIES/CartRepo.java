package com.NextLevel.USA.jpAREPOSITORIES;

import com.NextLevel.USA.DTO0.Response.CartResponseDTO;
import com.NextLevel.USA.DTO0.request.o.Cart.AddToCartDTO;
import com.NextLevel.USA.ENTITIES.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepo extends JpaRepository <Cart, Long> {


    Optional<Cart> findByUserEmail(String userEmail);


}
