package com.rent.system.service;

import com.rent.system.beans.AcceptDeliveryRequest;
import com.rent.system.beans.RentalRequest;
import com.rent.system.beans.RentalReturnRequest;
import com.rent.system.beans.customer.CustomerBean;
import com.rent.system.beans.owner.OwnerBean;
import com.rent.system.beans.product.RentalProduct;
import com.rent.system.beans.rental.RentalBean;
import com.rent.system.beans.rental.RentalOffer;
import com.rent.system.queues.RentalBeanQueueManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RentalBeanMapper {

    @Autowired
    RentalBeanQueueManager rentalBeanQueueManager;

    RentalBean newRequestToRentalBean(RentalRequest rentalRequest){
        RentalBean rentalBean = new RentalBean();
        rentalBean.setCustomerBean(rentalRequest.getCustomerBean());
        rentalBean.setProduct( rentalRequest.getProduct());
        rentalBean.setId(UUID.randomUUID().toString());
        rentalBeanQueueManager.addToQueue(rentalBean);
        return rentalBean;
    }

    public RentalBean rentalOffer2RentalBean(RentalOffer rentalOffer) {

        String price  = rentalOffer.getPrice();
        String timeline = rentalOffer.getTimeline();
        String rentalBeanReferenceId = rentalOffer.getRentalBeanRef();
        RentalBean rentalBean = rentalBeanQueueManager.
                searchRentalBean(rentalBeanReferenceId);
        rentalBean.setPrice(price);
        rentalBean.setOwnerBean(rentalOffer.getOwnerBean());
        rentalBean.setTimeline(timeline);
        return rentalBean;
    }

    public RentalBean acceptDeliveryBean2RentalBean(AcceptDeliveryRequest acceptDeliveryRequest) {
        String rentalBeanReferenceId = acceptDeliveryRequest.getRentalBeanReferenceId();
        RentalBean rentalBean = rentalBeanQueueManager.
                searchRentalBean(rentalBeanReferenceId);
        return rentalBean;

    }

    public RentalBean rentalReturnRequest2RentalBean(RentalReturnRequest rentalReturnRequest) {
        String rentalBeanReferenceId = rentalReturnRequest.getRentalBeanReferenceId();
        RentalBean rentalBean = rentalBeanQueueManager.
                searchRentalBean(rentalBeanReferenceId);
        return rentalBean;
    }
}
