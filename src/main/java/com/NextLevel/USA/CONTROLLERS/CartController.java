package com.NextLevel.USA.CONTROLLERS;



import com.NextLevel.USA.DTO0.Response.CartItemResponseDTO;
import com.NextLevel.USA.DTO0.Response.CartResponseDTO;
import com.NextLevel.USA.DTO0.request.o.Cart.AddToCartDTO;
import com.NextLevel.USA.SERVICESimpl.CartServiceImpl;
import com.NextLevel.USA.Services.CartServices;
import com.NextLevel.USA.jpAREPOSITORIES.CartRepo;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartServices cartServices;

    @GetMapping("/get")
    public ResponseEntity<CartResponseDTO> getCart(
            @AuthenticationPrincipal UserDetails user) {

        return ResponseEntity.ok(
                cartServices.getMyCart(user.getUsername())
        );
    }

    @PostMapping("/add")
    public ResponseEntity<CartResponseDTO> addToCart(
            @AuthenticationPrincipal UserDetails user,
            @RequestBody AddToCartDTO dto) {

        return ResponseEntity.ok(
                cartServices.addToCart(user.getUsername(), dto)
        );
    }
    @PutMapping("/{productId}")
    public ResponseEntity<CartResponseDTO> updateQuantity(
            @AuthenticationPrincipal UserDetails user,
            @PathVariable Long productId,
            @RequestBody Map<String, Integer> body) {

        Integer quantity = body.get("quantity");

        return ResponseEntity.ok(
                cartServices.updateQuantity(
                        user.getUsername(),
                        productId,
                        quantity
                )
        );
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> removeItem(
            @AuthenticationPrincipal UserDetails user,
            @PathVariable Long productId) {

        cartServices.removeItem(user.getUsername(), productId);
        return ResponseEntity.ok("Item removed");
    }

    @DeleteMapping("/clear")
    public ResponseEntity<?> clearCart(
            @AuthenticationPrincipal UserDetails user) {

        cartServices.clearCart(user.getUsername());
        return ResponseEntity.ok("Cart cleared");
    }
}
