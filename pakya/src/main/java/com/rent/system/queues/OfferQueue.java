package com.rent.system.queues;

import com.rent.system.beans.rental.RentalBean;
import com.rent.system.beans.rental.RentalOffer;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

@Data
@Component
public class OfferQueue {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    Queue<RentalBean> requestQueue =new LinkedList<>();

    public Optional<RentalBean> checkRentalRequest(String customerId) {
        logger.info("OfferQueue :: {}", requestQueue);
        Optional<RentalBean> rentalBean = requestQueue
                .stream()
                .filter(rentalQueue -> rentalQueue.getCustomerBean().getId().equalsIgnoreCase(customerId))
                .findFirst();
        return rentalBean;
    }

    /* Owner accept the request and offer the rental bid*/
    public boolean addRentalOffer(RentalBean rentalBean) {
        return requestQueue.add(rentalBean);
    }
}
