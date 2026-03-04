package com.NextLevel.USA.jpAREPOSITORIES;

import com.NextLevel.USA.DTO0.Response.DeliveryResponseDTO;
import com.NextLevel.USA.ENTITIES.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Optional<Delivery> findByOrderId(Long orderId);

}
