package com.rent.system.beans.delivery;

import com.rent.system.beans.customer.CustomerBean;
import com.rent.system.beans.owner.OwnerBean;
import com.rent.system.beans.product.RentalProduct;
import lombok.Data;

@Data
public class DeliveryDetails {
    CustomerBean customerBean;
    OwnerBean ownerBean;
    RentalProduct rentalProduct;
    DeliveryType deliveryType;
}
