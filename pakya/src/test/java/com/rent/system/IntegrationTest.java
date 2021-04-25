package com.rent.system;

import com.rent.system.beans.*;
import com.rent.system.beans.customer.CustomerBean;
import com.rent.system.beans.delivery.DeliveryBean;
import com.rent.system.beans.delivery.DeliveryRelation;
import com.rent.system.beans.delivery.DeliveryRequest;
import com.rent.system.beans.owner.OwnerBean;
import com.rent.system.beans.product.RentalProduct;
import com.rent.system.beans.rental.RentalBean;
import com.rent.system.beans.rental.RentalOffer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    @LocalServerPort
    int localServerPort;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void happyStory() {
        String base = "http://localhost:" + localServerPort;
        String url = "";
        CustomerBean customer = null;
        Object urlVariables = null;
        ResponseEntity<RentalResponse> response;

        customer = customer_creates_new_request_1(base, urlVariables);

        /*Customers Requests are checked by owner*/
        RentalResponse owner_rentalResponse = owner_read_customer_new_request_2(base);

        /*owner then accept the customer's request*/
      owner_accept_customer_request_3(base, owner_rentalResponse);

        response = customer_read_offer_4(base);

         customer_update_delivery_request_5(base, response);

        RentalBean rentalBean = delivery_read_request_6(base, urlVariables);

        delivery_accept_request_7(base, rentalBean, urlVariables);
        customer_raise_return_request_9(base, response.getBody().getRentalBean(),  urlVariables);



        rentalBean = delivery_read_request_6(base, urlVariables);

        delivery_accept_request_7(base, rentalBean, urlVariables);

 /*
        RentalBean customerRentalBean = customer_accept_delivery_request_8(base, urlVariables);
        */

        System.out.println("\n\n\n");
    }



    private CustomerBean customer_creates_new_request_1(String base, Object urlVariables) {
        String url;
        CustomerBean customer;
        url = base + "/customer/new-request";
        RentalRequest request = new RentalRequest();
        RentalProduct rentalProduct = new RentalProduct();
        rentalProduct.setProductDetails("TIG Welding");
        request.setProduct(rentalProduct);
        customer = new CustomerBean();
        customer.setId("2345433");
        customer.setLocation("Hadapsar");
        customer.setName("Pradeep");
        request.setCustomerBean(customer);
        request.setProduct(rentalProduct);
        request.setTimeline("Week 23");

        ResponseEntity<RentalResponse> response = testRestTemplate.
                postForEntity(url, request, RentalResponse.class, urlVariables);
        System.out.println("\n#1 Customer New Req Response :: " + response.getBody().getRentalBean().getId());
        return customer;
    }

    private RentalResponse owner_read_customer_new_request_2(String base) {
        String url;
        ResponseEntity<RentalResponse> response;
        url = base + "/owner/read-request";
        response = testRestTemplate.getForEntity(url, RentalResponse.class);
        System.out.println("\n#2 Owner Read Response Customer :: " + response.getBody().getRentalBean().getCustomerBean());
        return response.getBody();
    }


    private void owner_accept_customer_request_3(String base, RentalResponse rentalResponse) {
        String url;
        ResponseEntity<RentalResponse> response;
        url = base + "/owner/offer-rental";
        RentalOffer rentalOffer = new RentalOffer();
        rentalOffer.setRentalBeanRef(rentalResponse.getRentalBean().getId());
        rentalOffer.setOwnerBean(new OwnerBean());
        rentalOffer.getOwnerBean().setId("Vishal-OWNER-ID-12345");
        rentalOffer.setCustomerBean(rentalResponse.getRentalBean().getCustomerBean());
        rentalOffer.setPrice("1234454.12");
        rentalOffer.setProduct(rentalResponse.getRentalBean().getProduct());

        response = testRestTemplate.
                postForEntity(url, rentalOffer, RentalResponse.class);
        System.out.println("\n#3 Owner offer-rental Response :: " + response.getBody().getRentalBean());

    }

    private ResponseEntity<RentalResponse> customer_read_offer_4(String base) {
        String url;
        ResponseEntity<RentalResponse> response;
        url = base + "customer/read-offer?customerId=2345433";
        response = testRestTemplate.getForEntity(url, RentalResponse.class);
        System.out.println("\n#4 Customer read-offer Response :: " + response.getBody().getRentalBean());
        return response;
    }

 private void customer_update_delivery_request_5(String base, ResponseEntity<RentalResponse> response) {
        String url;
        url = base + "customer/update-offer";
        RentalBean rentalBean = response.getBody().getRentalBean();
        rentalBean.setDeliveryMethod("delivery");
        testRestTemplate.put(url, rentalBean);

        System.out.println("\n#5 Customer update-offer Response :: " + response.getBody().getRentalBean());
    }

    private RentalBean delivery_read_request_6(String base, Object urlVariables) {
        String url;
        System.out.println("\n");
        url = base + "/delivery/new-delivery-request";
        DeliveryBean deliveryBean = new DeliveryBean();
        deliveryBean.setLocation("KalePadal");
        deliveryBean.setName("Jitendra");
        ResponseEntity<RentalResponse> rentalResponseResponseEntity = testRestTemplate.
                postForEntity(url, deliveryBean, RentalResponse.class, urlVariables);
        RentalBean rentalBean = rentalResponseResponseEntity.getBody().getRentalBean();

        System.out.println("\n#6 deliveryRequest ::: " + rentalBean);
        return rentalBean;
    }

    private void delivery_accept_request_7(String base, RentalBean rentalBean, Object urlVariables) {
        String url;
        System.out.println("\n");
        url = base + "/delivery/accept-request";

        DeliveryBean deliveryBean = new DeliveryBean();
        deliveryBean.setLocation("KalePadal");
        deliveryBean.setName("Jitendra");
        AcceptDeliveryRequest acceptDeliveryRequest = new AcceptDeliveryRequest();
        acceptDeliveryRequest.setRentalBeanReferenceId(rentalBean.getId());

        ResponseEntity<RentalResponse> activeDeliveryResponse = testRestTemplate.
                postForEntity(url, acceptDeliveryRequest, RentalResponse.class, urlVariables);
        System.out.println("\n#7 activeDeliveryResponse ::: " + activeDeliveryResponse.getBody().getRentalBean());
    }
/*
    private RentalBean customer_accept_delivery_request_8(String base, Object urlVariables) {
        String url;
        System.out.println("\n");
        url = base + "/customer/accept-delivery";
        CustomerBean customerBean = new CustomerBean();
        customerBean.setName("Pradeep");
        ResponseEntity<RentalResponse> returnRentalResponse = testRestTemplate.postForEntity(
                url, customerBean, RentalResponse.class, urlVariables);
        System.out.println("\n#8 returnRentalResponse :: " +
                returnRentalResponse.getBody().getRentalBean());

        return returnRentalResponse.getBody().getRentalBean();
    }*/

    private void customer_raise_return_request_9(String base, RentalBean rentalBean, Object urlVariables) {
        String url;
        System.out.println("\n");
        url = base + "/customer/raise-return";
        RentalReturnRequest rentalReturnRequest = new RentalReturnRequest();

        OwnerBean owner = rentalBean.getOwnerBean();
        rentalReturnRequest.setRentalBeanReferenceId(rentalBean.getId());
        ResponseEntity<RentalResponse> returnRentalResponse = testRestTemplate.postForEntity(
                url, rentalReturnRequest, RentalResponse.class, urlVariables);
        System.out.println("\n#9 customer_raise_return_request_9 returnRentalResponse :: " + returnRentalResponse);
    }

    private void delivery_check_return_request_10(String base, Object urlVariables, DeliveryRequest newDeliveryRequest) {
        String url;
        System.out.println("\n");
        url = base + "/delivery/new-delivery-request";
        ResponseEntity<DeliveryBean> newReturndeliveryResponse = testRestTemplate.postForEntity(url, newDeliveryRequest, DeliveryBean.class, urlVariables);
        System.out.println("\n#9 new ReturndeliveryResponse ::: " + newReturndeliveryResponse);
    }

    private void delivery_check_request_11(String base, Object urlVariables) {
        String url;
        System.out.println("\n");
        url = base + "/delivery/accept-request";
        DeliveryRequest activeReturnDeliveryRequest = new DeliveryRequest();
        ResponseEntity<DeliveryBean> activeReturnDeliveryResponse = testRestTemplate.postForEntity(url, activeReturnDeliveryRequest, DeliveryBean.class, urlVariables);
        System.out.println("\n#10 activeDeliveryResponseð ::: " + activeReturnDeliveryResponse);
    }

}
