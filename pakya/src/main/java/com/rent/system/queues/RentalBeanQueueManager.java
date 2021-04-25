package com.rent.system.queues;

import com.rent.system.beans.rental.RentalBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
@Component
public class RentalBeanQueueManager {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    Queue<RentalBean> requestQueue =new LinkedList<>();

    public boolean addToQueue(RentalBean rentalBean){
        boolean status = requestQueue.add(rentalBean);
        return status;
    }

    public RentalBean searchRentalBean(String rentalBeanRef){
        RentalBean rentalBean=null;
        Optional<RentalBean> optionalRentalBean = requestQueue.stream().filter(rentalBean1 -> rentalBean1.getId().equals(rentalBeanRef)).findFirst();
        rentalBean = optionalRentalBean.get();
        return rentalBean;
    }

}
