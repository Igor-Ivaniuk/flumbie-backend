package com.zooplus.fumbliebackend.model.dto.getOrder;

import lombok.Data;

@Data
public class GetOrderAddressDto {
    private Long id;

    private String name;

    private String street;

    private String city;

    private String zipCode;

    private String country;

}
