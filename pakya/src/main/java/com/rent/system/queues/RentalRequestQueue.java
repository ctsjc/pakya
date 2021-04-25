package com.rent.system.queues;

import com.rent.system.beans.RentalRequest;
import com.rent.system.beans.rental.RentalBean;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;
@Data
@Component
public class RentalRequestQueue {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    Queue<RentalBean> requestQueue =new LinkedList<>();

    public boolean accept(RentalBean rentalBean) {
        boolean status = requestQueue.add(rentalBean);
        logger.info("Request Queue is updated : "+ requestQueue.size());
        return status;
    }

    public RentalBean readRentalRequest() {
        return requestQueue.peek();
    }
}
