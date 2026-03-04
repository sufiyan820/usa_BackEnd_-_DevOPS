package com.NextLevel.USA.CONTROLLERS;


import com.NextLevel.USA.DTO0.Response.DeliveryResponseDTO;
import com.NextLevel.USA.DTO0.request.o.DeliveryReq.DeliveryRequestDTO;
import com.NextLevel.USA.SERVICESimpl.DeliveryServiceIMPL;
import com.NextLevel.USA.jpAREPOSITORIES.DeliveryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/delivery")
public class DeliveryController {

    private final DeliveryServiceIMPL  deliveryServiceIMPL;

    public DeliveryController(DeliveryServiceIMPL deliveryServiceIMPL) {
        this.deliveryServiceIMPL = deliveryServiceIMPL;
    }


    @PostMapping("/create")
    public ResponseEntity<DeliveryResponseDTO> create(
            @RequestBody DeliveryRequestDTO request
    )  {
        return ResponseEntity.ok(deliveryServiceIMPL.createDelivery(request));
    }
}
