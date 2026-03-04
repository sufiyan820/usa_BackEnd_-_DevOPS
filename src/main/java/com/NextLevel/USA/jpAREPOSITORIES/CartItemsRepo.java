package com.NextLevel.USA.jpAREPOSITORIES;

import com.NextLevel.USA.ENTITIES.CartItems;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepo extends JpaRepository<CartItems, Long> {
}
