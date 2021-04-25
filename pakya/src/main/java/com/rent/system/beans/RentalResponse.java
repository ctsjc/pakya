package com.rent.system.beans;

import com.rent.system.beans.delivery.DeliveryRequest;
import com.rent.system.beans.rental.RentalBean;
import com.rent.system.beans.rental.RentalOffer;
import lombok.Data;

@Data
public class RentalResponse {
    String status;
    RentalOffer rentalOffer;
    RentalRequest rentalRequest;
    DeliveryRequest deliveryRequest;
    RentalBean rentalBean;
    public RentalResponse() {
    }

    public RentalResponse(String status) {
        this.status = status;
    }
}
