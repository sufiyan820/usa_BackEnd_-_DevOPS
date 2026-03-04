package com.NextLevel.USA.CONTROLLERS;


import com.NextLevel.USA.DTO0.Response.OrderResponseDTO;
import com.NextLevel.USA.DTO0.request.o.Order.PlaceOrderDTO;
import com.NextLevel.USA.Enum.OrderStatus;
import com.NextLevel.USA.Services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<OrderResponseDTO> placeOrder(@RequestBody PlaceOrderDTO dto) {
        return ResponseEntity.ok(orderService.placeOrder(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderResponseDTO>> getUserOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<?> updateOrderStatus(
            @PathVariable Long orderId,
            @RequestBody Map<String, String> body) {

        String status = body.get("status");

        orderService.updateOrderStatus(orderId, OrderStatus.valueOf(status));

        return ResponseEntity.ok("Order status updated");
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
        return ResponseEntity.ok("Order Cancelled Successfully");
    }
}
