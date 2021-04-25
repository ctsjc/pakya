package com.rent.system.queues;

import com.rent.system.beans.*;
import com.rent.system.beans.customer.CustomerBean;
import com.rent.system.beans.delivery.DeliveryBean;
import com.rent.system.beans.delivery.DeliveryRequest;
import com.rent.system.beans.rental.RentalBean;
import com.rent.system.beans.rental.RentalOffer;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Data
@Component
public class DeliveryQueue {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    Queue<RentalBean> requestQueue =new LinkedList<>();
    Queue<RentalBean> activeDeliveryQueue =new LinkedList<>();

    public boolean addReturnRentalRequest(RentalBean rentalBean) {
        boolean status = requestQueue.add(rentalBean);
        logger.info("Delivery Queue size :: "+ requestQueue.size());
        return status;
    }

    public RentalBean fetchDeliveryRequest() {
        RentalBean queueInstance = requestQueue.peek();
        logger.info("deliveryResponse {} {}",requestQueue, queueInstance);
        return queueInstance;
    }

    public boolean addActiveDeliveryRequest(RentalBean deliveryRequest) {
        return activeDeliveryQueue.add(deliveryRequest);
    }

    public RentalBean removeFromDeliveryQueue(CustomerBean customerBean) {
        RentalBean rentalBean = new RentalBean();
        if( !activeDeliveryQueue.isEmpty()) {
            rentalBean = activeDeliveryQueue.poll();
            return rentalBean;
        }
        return rentalBean;
    }
}
