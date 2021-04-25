package com.rent.system.controller;

import com.rent.system.beans.*;
import com.rent.system.beans.delivery.DeliveryBean;
import com.rent.system.beans.delivery.DeliveryRelation;
import com.rent.system.beans.delivery.DeliveryRequest;
import com.rent.system.beans.rental.RentalBean;
import com.rent.system.service.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("delivery")
public class DeliveryController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    // check the delivery Request
    // Accept the delivery
    // collect the product
    // ack delivered the product

    @Autowired
    DeliveryService deliveryService;

    @PostMapping("new-delivery-request")
    RentalResponse checkDeliveryRequest(@RequestBody DeliveryBean deliveryBean){
        RentalResponse rentalResponse = new RentalResponse("fail");
        RentalBean rentalBean = deliveryService.fetchDeliveryRequest(deliveryBean);
        logger.info("deliveryRequest {}", rentalBean);
        rentalResponse.setRentalBean(rentalBean);
        return rentalResponse;

    }
    @PostMapping("accept-request")
    RentalResponse acceptDelivery(@RequestBody AcceptDeliveryRequest acceptDeliveryRequest){
        logger.info("accept-request is invoked.");
        RentalResponse rentalResponse = new RentalResponse("fail");
        RentalBean  rentalBean = deliveryService.acceptDelivery(acceptDeliveryRequest);
        logger.info("rentalBean {}", rentalBean);
        rentalResponse.setRentalBean(rentalBean);
        return rentalResponse;
    }
}
