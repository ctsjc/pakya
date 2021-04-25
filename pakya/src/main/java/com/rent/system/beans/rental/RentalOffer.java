package com.rent.system.beans.rental;

import com.rent.system.beans.customer.CustomerBean;
import com.rent.system.beans.owner.OwnerBean;
import com.rent.system.beans.product.RentalProduct;
import lombok.Data;

@Data
public class RentalOffer {
    String rentalBeanRef;
    CustomerBean customerBean;
    RentalProduct product;
    String timeline;
    String price;
    OwnerBean ownerBean;
}
