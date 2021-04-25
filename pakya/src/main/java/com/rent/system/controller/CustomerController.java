package com.rent.system.controller;

import com.rent.system.beans.*;
import com.rent.system.beans.customer.CustomerBean;
import com.rent.system.beans.delivery.DeliveryRequest;
import com.rent.system.beans.rental.RentalBean;
import com.rent.system.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("customer")
public class CustomerController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    // Raise the product request
    // Check the product offer
    // Accept the product offer: Choose Delivery or Pick up
    // Accept the product delivery
    // Confirm Product Delivery
    // Raise the product return delivery Request

    @Autowired
    CustomerService customerService;

    @PostMapping("new-request")
    RentalResponse raiseProductRequest(@RequestBody RentalRequest rentalRequest) {
        RentalResponse response = new RentalResponse("Failed");

        customerService.acceptNewRequest(rentalRequest).ifPresent(val ->{
            response.setRentalBean(val);
            response.setStatus("SUCCESS");
        });

        return response;
    }

    /*ProductOwner sends the bid, which customer can accept*/
    @GetMapping("read-offer")
    RentalResponse checkOffer(@RequestParam String customerId) {
        Optional<RentalBean> rentalOffer = customerService.checkOffer(customerId);
        logger.info("read-offer :: {}", rentalOffer);
        RentalResponse rentalResponse = new RentalResponse();
        rentalResponse.setRentalBean(rentalOffer.get());
        return rentalResponse;
    }

    /* Update the offer with delivery method*/
    @PutMapping("update-offer")
    RentalResponse updateRentalDeliveryMode(@RequestBody RentalBean rentalBean) {
        RentalResponse rentalResponse = new RentalResponse("Fail");
        if (customerService.updateRentalDeliveryMode(rentalBean))
            rentalResponse.setStatus("Success");
        return rentalResponse;
    }

    /* customer raise the return response */
    @PostMapping("raise-return")
    RentalResponse raiseProductReturn(@RequestBody RentalReturnRequest rentalReturnRequest) {
        RentalResponse rentalResponse = new RentalResponse("Fail");

        if (customerService.raiseProductReturn(rentalReturnRequest)) {
            rentalResponse.setStatus("Success");

        }
        return rentalResponse;
    }
}
