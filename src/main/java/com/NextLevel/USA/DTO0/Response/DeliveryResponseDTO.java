package com.NextLevel.USA.DTO0.Response;

import com.NextLevel.USA.Enum.DeliveryStatus;

import java.time.LocalDate;



public class DeliveryResponseDTO {
    private Long id;
    private String trackingNumber;
    private String deliveryPartner;
    private DeliveryStatus deliveryStatus;
    private LocalDate estimatedDeliveryDate;

    public DeliveryResponseDTO() {
        this.id = id;
        this.trackingNumber = trackingNumber;
        this.deliveryPartner = deliveryPartner;
        this.deliveryStatus = deliveryStatus;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getDeliveryPartner() {
        return deliveryPartner;
    }

    public void setDeliveryPartner(String deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }
}
