package com.NextLevel.USA.DTO0.request.o.Order;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PlaceOrderDTO {

    private Long userId;
    private Double totalAmount;
    private String shippingAddress;


}
