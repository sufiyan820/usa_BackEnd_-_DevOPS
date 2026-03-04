package com.NextLevel.USA.Mapper;

import com.NextLevel.USA.DTO0.Response.OrderResponseDTO;
import com.NextLevel.USA.ENTITIES.Order;

public class OrderMapper {
    public static OrderResponseDTO toDTO(Order order) {

        if (order == null) {
            return null;
        }

        return OrderResponseDTO.builder()
                .orderId(order.getId())
                .userId(order.getUserId())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus())
                .shippingAddress(order.getShippingAddress())
                .createdDate(order.getCreatedAt())
                .build();
    }
}
