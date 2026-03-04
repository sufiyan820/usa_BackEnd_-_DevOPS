package com.NextLevel.USA.Mapper;

import com.NextLevel.USA.DTO0.Response.DeliveryResponseDTO;
import com.NextLevel.USA.ENTITIES.Delivery;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DeliveryMapper {
    public DeliveryResponseDTO toDeliveryResponseDTO(Delivery delivery) {
        DeliveryResponseDTO dto = new DeliveryResponseDTO();
        dto.setId(delivery.getId());
        dto.setTrackingNumber(delivery.getTrackingNumber());
        dto.setDeliveryPartner(delivery.getDeliveryPartner());
        dto.setDeliveryStatus(delivery.getStatus());
        dto.setEstimatedDeliveryDate(delivery.getEstimatedDeliveryDate());

        return  dto;
    }
}
