package com.zooplus.fumbliebackend.model.dto.placeOrder;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class PlaceOrderAddressDto {
    private String name;

    private String street;

    private String city;

    private String zipCode;

    private String country;

}
