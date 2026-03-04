package com.NextLevel.USA.ENTITIES;


import com.NextLevel.USA.Enum.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private  Double totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String shippingAddress;
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Delivery delivery;


}
