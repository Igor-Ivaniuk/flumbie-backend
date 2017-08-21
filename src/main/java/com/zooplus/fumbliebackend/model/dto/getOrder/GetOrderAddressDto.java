package com.zooplus.fumbliebackend.model.dto.getOrder;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class GetOrderAddressDto {
    private Long id;

    private String name;

    private String street;

    private String city;

    private String zipCode;

    private String country;

}
