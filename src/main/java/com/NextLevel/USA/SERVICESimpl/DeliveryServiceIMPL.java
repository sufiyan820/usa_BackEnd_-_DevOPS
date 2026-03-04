package com.NextLevel.USA.SERVICESimpl;

import com.NextLevel.USA.DTO0.Response.DeliveryResponseDTO;
import com.NextLevel.USA.DTO0.request.o.DeliveryReq.DeliveryRequestDTO;
import com.NextLevel.USA.ENTITIES.Delivery;
import com.NextLevel.USA.ENTITIES.Order;
import com.NextLevel.USA.Enum.DeliveryStatus;
import com.NextLevel.USA.Mapper.DeliveryMapper;
import com.NextLevel.USA.Services.DeliveryService;
import com.NextLevel.USA.jpAREPOSITORIES.DeliveryRepository;
import com.NextLevel.USA.jpAREPOSITORIES.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;


@Service
public class DeliveryServiceIMPL implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private  final OrderRepository  orderRepository;
    private final DeliveryMapper deliveryMapper;

    public DeliveryServiceIMPL(DeliveryRepository deliveryRepository, OrderRepository orderRepository, DeliveryMapper deliveryMapper) {
        this.deliveryRepository = deliveryRepository;
        this.orderRepository = orderRepository;
        this.deliveryMapper = deliveryMapper;
    }

    @Override
    public DeliveryResponseDTO createDelivery(DeliveryRequestDTO request) {
        Order order  = orderRepository.findById(request.getOrderId())
        .orElseThrow(()-> new RuntimeException("OoPss Order Not Found"));


        Optional<Delivery> existingDelivery =
                deliveryRepository.findById(request.getOrderId());

        if (existingDelivery.isPresent()) {
            throw new RuntimeException("Delivery already created for this order");
        }

        Delivery delivery = new Delivery();
        delivery.setTrackingNumber(UUID.randomUUID().toString());
        delivery.setDeliveryPartner(request.getDeliveryPartner());
        delivery.setStatus(DeliveryStatus.PENDING);
        delivery.setEstimatedDeliveryDate(request.getEstimatedDeliveryDate());
        delivery.setOrder(order);
        return deliveryMapper.toDeliveryResponseDTO(deliveryRepository.save(delivery));
    }

    @Override
    public DeliveryResponseDTO updateStatus(Long deliveryId, DeliveryStatus status) {


        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(()-> new RuntimeException("Sorry Boss but we regret to inform you that your Delivery Not Found"));

        delivery.setStatus(status);
        if (status == DeliveryStatus.DELIVERED){
            delivery.setDeliveryDate(LocalDate.now());
        }
        return deliveryMapper.toDeliveryResponseDTO(deliveryRepository.save(delivery));

    }

    @Override
    public DeliveryResponseDTO getByOrderId(Long orderId) {

        Delivery delivery = deliveryRepository.findById(orderId)
                .orElseThrow(()-> new RuntimeException("check your cart: \n Order Not Found  "));
        return deliveryMapper.toDeliveryResponseDTO(delivery);
    }
}
