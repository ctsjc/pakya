package com.rent.system.service;

import com.rent.system.beans.*;
import com.rent.system.beans.customer.CustomerBean;
import com.rent.system.beans.delivery.DeliveryRequest;
import com.rent.system.beans.rental.RentalBean;
import com.rent.system.beans.rental.RentalOffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService {
    Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    RentalBeanMapper beanMapper;

    @Autowired
    RentalQueueManager queueManager;
    public Optional<RentalBean>  acceptNewRequest(RentalRequest rentalRequest){
        logger.info("Accepting the new request");
        RentalBean rentalBean = beanMapper.newRequestToRentalBean(rentalRequest);
        logger.info("Rental Bean acceptNewRequest :: {}",rentalBean);
        if(queueManager.acceptNewRequest(rentalBean))
            return Optional.of(rentalBean);
        return Optional.empty();
    }

    public Optional<RentalBean> checkOffer(String customerId) {
        return queueManager.checkOffer(customerId);
    }

    public boolean updateRentalDeliveryMode(RentalBean rentalBean) {
        boolean status = false;
        if( rentalBean.getDeliveryMethod().equalsIgnoreCase("delivery")){
            status = queueManager.addDeliveryQueue(rentalBean);
        }
        return  status;
    }

    public boolean raiseProductReturn(RentalReturnRequest rentalReturnRequest) {
        RentalBean rentalBean = beanMapper.rentalReturnRequest2RentalBean(rentalReturnRequest);
        return queueManager.addReturnDeliveryQueue( rentalBean);
    }

    public RentalBean customerAcceptDelivery(CustomerBean customerBean) {
        return queueManager.removeFromDeliveryQueue(customerBean);
    }
}
