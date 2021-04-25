package com.rent.system.service;

import com.rent.system.beans.*;
import com.rent.system.beans.customer.CustomerBean;
import com.rent.system.beans.delivery.DeliveryRequest;
import com.rent.system.beans.rental.RentalBean;
import com.rent.system.beans.rental.RentalOffer;
import com.rent.system.queues.DeliveryQueue;
import com.rent.system.queues.OfferQueue;
import com.rent.system.queues.RentalRequestQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RentalQueueManager {
    @Autowired
    RentalRequestQueue rentalRequestQueue;

    @Autowired
    OfferQueue offerQueue;

    @Autowired
    DeliveryQueue deliveryQueue;

    public boolean acceptNewRequest(RentalBean rentalBean) {
        return rentalRequestQueue.accept(rentalBean);
    }

    public Optional<RentalBean> checkOffer(String customerId) {
        return offerQueue.checkRentalRequest(customerId);
    }

    public boolean addDeliveryQueue(RentalBean rentalBean) {
        return deliveryQueue.addReturnRentalRequest(rentalBean);
    }

    public boolean addReturnDeliveryQueue(RentalBean rentalReturnRequest) {
        return  deliveryQueue.addReturnRentalRequest(rentalReturnRequest);
    }

    public RentalBean checkNewRentalRequest() {
        return rentalRequestQueue.readRentalRequest();
    }

    // owner accepted the customer's request, its now into delivery mode
    public boolean bidRentOffer(RentalBean rentalBean) {
        return offerQueue.addRentalOffer(rentalBean);
    }

    public RentalBean fetchDeliveryRequest() {
        return deliveryQueue.fetchDeliveryRequest();
    }

    public boolean addActiveDeliveryRequest(RentalBean deliveryRequest) {
        return deliveryQueue.addActiveDeliveryRequest( deliveryRequest);
    }

    public RentalBean removeFromDeliveryQueue(CustomerBean customerBean) {
        return deliveryQueue.removeFromDeliveryQueue( customerBean);
    }
}
