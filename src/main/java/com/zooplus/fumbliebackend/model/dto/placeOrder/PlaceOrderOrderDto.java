package com.zooplus.fumbliebackend.model.dto.placeOrder;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PlaceOrderOrderDto {
    private List<PlaceOrderOrderItemDto> orderItems;

    private BigDecimal totalAmount;

    private String currency;

    private PlaceOrderAddressDto address;
}
