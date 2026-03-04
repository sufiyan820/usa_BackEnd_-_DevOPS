package com.NextLevel.USA.Services;

import com.NextLevel.USA.DTO0.Response.OrderResponseDTO;
import com.NextLevel.USA.DTO0.request.o.Order.PlaceOrderDTO;
import com.NextLevel.USA.Enum.OrderStatus;

import java.util.List;

public interface OrderService {
    OrderResponseDTO placeOrder(PlaceOrderDTO dto);

    OrderResponseDTO getOrderById(Long id);
    OrderResponseDTO updateOrderStatus(Long id, OrderStatus status);

    List<OrderResponseDTO> getOrdersByUser(Long userId);

    void cancelOrder(Long id);
}
