package com.rent.system.beans;

import com.rent.system.beans.customer.CustomerBean;
import com.rent.system.beans.product.RentalProduct;
import lombok.Data;

@Data
public class RentalRequest {
    CustomerBean customerBean;
    RentalProduct product;
    String timeline;
}
