package com.rent.system.beans.rental;

import com.rent.system.beans.customer.CustomerBean;
import com.rent.system.beans.delivery.DeliveryBean;
import com.rent.system.beans.delivery.DeliveryStatus;
import com.rent.system.beans.delivery.DeliveryType;
import com.rent.system.beans.owner.OwnerBean;
import com.rent.system.beans.product.RentalProduct;
import lombok.Data;

@Data
/*This should be the live snapshot of Rental, It will also keep the reference of previous status of himself
* in future, multiple owner and multiple delivery people will be considered.
* it will be stored in various queues and
* it will help to create the response or request whenever needed as per logic
* */
public class RentalBean {
    String id;
    String   deliveryMethod;
    CustomerBean customerBean;
    RentalProduct product;
    String timeline;
    String price;
    OwnerBean ownerBean;
    RentalProduct rentalProduct;
    DeliveryType deliveryType;
    DeliveryStatus deliveryStatus;
    DeliveryBean deliveryBean;
    RentalBean history;
}
