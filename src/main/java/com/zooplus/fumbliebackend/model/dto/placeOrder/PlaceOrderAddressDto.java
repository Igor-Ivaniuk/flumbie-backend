package com.zooplus.fumbliebackend.model.dto.placeOrder;

import lombok.Data;

@Data
public class PlaceOrderAddressDto {
    private String name;

    private String street;

    private String city;

    private String zipCode;

    private String country;

}
