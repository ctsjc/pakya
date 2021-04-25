package com.rent.system.beans.delivery;

import lombok.Data;

@Data
public class DeliveryRelation {
    DeliveryBean deliveryBean;
    DeliveryRequest deliveryRequest;
    DeliveryStatus deliveryStatus;
}
