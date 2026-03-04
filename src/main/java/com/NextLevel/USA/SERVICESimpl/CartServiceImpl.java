 package com.NextLevel.USA.SERVICESimpl;


import com.NextLevel.USA.DTO0.Response.CartItemResponseDTO;
import com.NextLevel.USA.DTO0.Response.CartResponseDTO;
import com.NextLevel.USA.DTO0.request.o.Cart.AddToCartDTO;
import com.NextLevel.USA.ENTITIES.Cart;
import com.NextLevel.USA.ENTITIES.CartItems;
import com.NextLevel.USA.ENTITIES.Products;
import com.NextLevel.USA.Mapper.CartMapper;
import com.NextLevel.USA.Services.CartServices;
import com.NextLevel.USA.jpAREPOSITORIES.CartItemsRepo;
import com.NextLevel.USA.jpAREPOSITORIES.CartRepo;
import com.NextLevel.USA.jpAREPOSITORIES.Productrepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
 @Service
 public class CartServiceImpl implements CartServices {

     private final CartRepo cartRepository;
     private final Productrepo productRepository;

     public CartServiceImpl(CartRepo cartRepository,
                            Productrepo productRepository) {
         this.cartRepository = cartRepository;
         this.productRepository = productRepository;
     }

     // ✅ GET MY CART
     @Override
     public CartResponseDTO getMyCart(String userEmail) {

         Cart cart = cartRepository.findByUserEmail(userEmail)
                 .orElseThrow(() -> new RuntimeException("Cart not found"));

         return buildCartResponse(cart);
     }

     // ✅ ADD TO CART
     @Override
     @Transactional
     public CartResponseDTO addToCart(String userEmail, AddToCartDTO dto) {

         Cart cart = cartRepository.findByUserEmail(userEmail)
                 .orElseGet(() -> {
                     Cart newCart = new Cart();
                     newCart.setUserEmail(userEmail);
                     return cartRepository.save(newCart);
                 });

         Products product = productRepository.findById(dto.getProductId())
                 .orElseThrow(() -> new RuntimeException("Product not found"));

         CartItems item = new CartItems();
         item.setCart(cart);          // 🔥 MUST SET
         item.setProduct(product);    // 🔥 MUST SET
         item.setQuantity(dto.getQuantity());

         cart.getItems().add(item);   // 🔥 IMPORTANT

         cartRepository.save(cart);   // 🔥 SAVE CART (not item)

         return buildCartResponse(cart);
     }



     // ✅ UPDATE QUANTITY
     @Override
     public CartResponseDTO updateQuantity(String userEmail,
                                           Long productId,
                                           Integer quantity) {

         Cart cart = cartRepository.findByUserEmail(userEmail)
                 .orElseThrow(() -> new RuntimeException("Cart not found"));

         CartItems item = cart.getItems().stream()
                 .filter(i -> i.getProduct().getId().equals(productId))
                 .findFirst()
                 .orElseThrow(() -> new RuntimeException("Product not in cart"));

         if (quantity <= 0) {
             cart.getItems().remove(item);
         } else {
             item.setQuantity(quantity);
         }

         cartRepository.save(cart);

         return buildCartResponse(cart);
     }

     // ✅ REMOVE ITEM
     @Override
     public void removeItem(String email, Long productId) {

         Cart cart = cartRepository.findByUserEmail(email)
                 .orElseThrow(() -> new RuntimeException("Cart not found"));

         cart.getItems().removeIf(item ->
                 item.getProduct().getId().equals(productId));

         cartRepository.save(cart);
     }

     // ✅ CLEAR CART
     @Override
     public void clearCart(String email) {

         Cart cart = cartRepository.findByUserEmail(email)
                 .orElseThrow(() -> new RuntimeException("Cart not found"));

         cart.getItems().clear();
         cartRepository.save(cart);
     }

     // ✅ BUILD RESPONSE
     private CartResponseDTO buildCartResponse(Cart cart) {

         List<CartItemResponseDTO> items =
                 cart.getItems().stream()
                         .map(CartMapper::mapItem)
                         .toList();

         double subtotal = items.stream()
                 .mapToDouble(CartItemResponseDTO::getTotalPrice)
                 .sum();

         return new CartResponseDTO(
                 cart.getId(),
                 cart.getUserEmail(),
                 items,
                 subtotal,
                 subtotal
         );
     }
 }
