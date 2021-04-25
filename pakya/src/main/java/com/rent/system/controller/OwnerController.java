package com.rent.system.controller;

import com.rent.system.beans.delivery.DeliveryRequest;
import com.rent.system.beans.rental.RentalBean;
import com.rent.system.beans.rental.RentalOffer;
import com.rent.system.beans.RentalRequest;
import com.rent.system.beans.RentalResponse;
import com.rent.system.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("owner")
public class OwnerController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    // Get Product Request
    // Accept Product Request, Offer the product
    // Accept the Return Delivery

    @Autowired
    OwnerService ownerService;

    @GetMapping("read-request")
    RentalResponse checkNewRantalRequest(RentalRequest rentalRequest) {
        RentalResponse rentalResponse = new RentalResponse();
        RentalBean rentalBean = ownerService.checkNewRentalRequest();
        rentalResponse.setRentalBean(rentalBean);   // Exposing too much information here
        return rentalResponse;
    }

    @PostMapping("offer-rental")
    RentalResponse acceptRentalRequest(@RequestBody RentalOffer rentalOffer) {
        logger.info("offer-rental rentalRequest {}", rentalOffer);
        RentalResponse rentalResponse = new RentalResponse();
        RentalOffer updatedRentalOffer = ownerService.bidRentalOffer(rentalOffer);
        logger.info("offer-rental rentalOffer {}", updatedRentalOffer);

        rentalResponse.setRentalOffer(updatedRentalOffer);
        return rentalResponse;
    }
}