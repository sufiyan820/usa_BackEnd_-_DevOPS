package com.NextLevel.USA.ENTITIES;

import com.NextLevel.USA.Enum.DeliveryStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class Delivery {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


    private String trackingNumber;

    private String deliveryPartner;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    private LocalDate estimatedDeliveryDate;
    private  LocalDate deliveryDate;


    @OneToOne
    @JoinColumn(name = "orders")
    private Order order;


    public Delivery(Long id, String trackingNumber, DeliveryStatus status, String deliveryPartner, LocalDate estimatedDeliveryDate, LocalDate deliveryDate, Order order) {
        Id = id;
        this.trackingNumber = trackingNumber;
        this.status = status;
        this.deliveryPartner = deliveryPartner;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.deliveryDate = deliveryDate;
        this.order = order;
    }

    public Delivery() {

    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDeliveryPartner() {
        return deliveryPartner;
    }

    public void setDeliveryPartner(String deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
