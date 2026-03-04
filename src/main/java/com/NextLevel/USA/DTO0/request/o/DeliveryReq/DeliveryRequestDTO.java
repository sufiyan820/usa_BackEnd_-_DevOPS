package com.NextLevel.USA.DTO0.request.o.DeliveryReq;

import java.time.LocalDate;

public class DeliveryRequestDTO {

    private Long orderId;
    private String deliveryPartner;
    private LocalDate estimatedDeliveryDate;

    public DeliveryRequestDTO(Long orderId, String deliveryPartner, LocalDate estimatedDeliveryDate) {
        this.orderId = orderId;
        this.deliveryPartner = deliveryPartner;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryPartner() {
        return deliveryPartner;
    }

    public void setDeliveryPartner(String deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }
}
