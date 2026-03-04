package com.NextLevel.USA.jpAREPOSITORIES;

import com.NextLevel.USA.ENTITIES.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
