package com.NextLevel.USA.DTO0.Response;

import com.NextLevel.USA.Enum.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
public class OrderResponseDTO {

    private  Long orderId;
    private Long userId;
    private Double totalAmount;
    private OrderStatus status;
    private String shippingAddress;
    private LocalDateTime createdDate;



}
