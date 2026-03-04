package com.NextLevel.USA.SERVICESimpl;

import com.NextLevel.USA.DTO0.Response.OrderResponseDTO;
import com.NextLevel.USA.DTO0.request.o.Order.PlaceOrderDTO;
import com.NextLevel.USA.ENTITIES.Order;
import com.NextLevel.USA.Enum.OrderStatus;
import com.NextLevel.USA.Mapper.OrderMapper;
import com.NextLevel.USA.Services.OrderService;
import com.NextLevel.USA.jpAREPOSITORIES.OrderRepository;
import org.springframework.stereotype.Service;



import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service

public class OrderServices implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServices(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderResponseDTO placeOrder(PlaceOrderDTO dto) {

        Order order = Order.builder()
                .userId(dto.getUserId())
                .totalAmount(dto.getTotalAmount())
                .shippingAddress(dto.getShippingAddress())
                .status(OrderStatus.CREATED)
                .createdAt(LocalDateTime.now())
                .build();

        Order saved = orderRepository.save(order);

        return OrderMapper.toDTO(saved);
    }

    @Override
    public OrderResponseDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return OrderMapper.toDTO(order);
    }

    @Override
    public OrderResponseDTO updateOrderStatus(Long id, OrderStatus status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        orderRepository.save(order);
        return OrderMapper.toDTO(order);
    }

    @Override
    public List<OrderResponseDTO> getOrdersByUser(Long userId) {

        return orderRepository.findByUserId(userId)
                .stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void cancelOrder(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(OrderStatus.CANCELLED);
        orderRepository.save(order);
    }
}
