package com.rent.system.service;

import com.rent.system.beans.owner.OwnerBean;
import com.rent.system.beans.rental.RentalBean;
import com.rent.system.beans.rental.RentalOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    @Autowired
    RentalQueueManager queueManager;

    @Autowired
    RentalBeanMapper beanMapper;
    public RentalBean checkNewRentalRequest() {
        return queueManager.checkNewRentalRequest();
    }

    public RentalOffer bidRentalOffer(RentalOffer rentalOffer) {
        RentalBean rentalBean = beanMapper.rentalOffer2RentalBean(rentalOffer);

         if(queueManager.bidRentOffer(rentalBean)){
             rentalOffer.setCustomerBean(rentalBean.getCustomerBean());
             // update the owner information
             OwnerBean ownerBean=new OwnerBean();
             ownerBean.setName("OwnerName");
             ownerBean.setId(rentalOffer.getOwnerBean().getId());
             rentalOffer.setOwnerBean(ownerBean);
         }
         return rentalOffer;
    }
}
