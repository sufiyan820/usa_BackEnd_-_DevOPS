package com.NextLevel.USA.Services;

import com.NextLevel.USA.DTO0.Response.DeliveryResponseDTO;
import com.NextLevel.USA.DTO0.request.o.DeliveryReq.DeliveryRequestDTO;
import com.NextLevel.USA.Enum.DeliveryStatus;

public interface DeliveryService {

    DeliveryResponseDTO createDelivery(DeliveryRequestDTO request);
    DeliveryResponseDTO updateStatus(Long deliveryId, DeliveryStatus status);
    DeliveryResponseDTO getByOrderId(Long orderId);
}
