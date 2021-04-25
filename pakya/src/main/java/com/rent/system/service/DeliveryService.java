package com.rent.system.service;

import com.rent.system.beans.AcceptDeliveryRequest;
import com.rent.system.beans.delivery.DeliveryBean;
import com.rent.system.beans.delivery.DeliveryRelation;
import com.rent.system.beans.delivery.DeliveryRequest;
import com.rent.system.beans.rental.RentalBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    RentalQueueManager queueManager;

    @Autowired
    RentalBeanMapper rentalBeanMapper;

    public RentalBean fetchDeliveryRequest(DeliveryBean deliveryBean) {
        RentalBean rentalBean = queueManager.fetchDeliveryRequest();
        return rentalBean;
    }

    public RentalBean acceptDelivery(AcceptDeliveryRequest acceptDeliveryRequest) {
        RentalBean rentalBean = rentalBeanMapper.acceptDeliveryBean2RentalBean(acceptDeliveryRequest);
        queueManager.addActiveDeliveryRequest(rentalBean);
        return rentalBean;
    }
}
