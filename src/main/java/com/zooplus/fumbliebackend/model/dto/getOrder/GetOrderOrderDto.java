package com.zooplus.fumbliebackend.model.dto.getOrder;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Data
public class GetOrderOrderDto {
    private Long id;

    private List<GetOrderOrderItemDto> orderItems;

    private BigDecimal totalAmount;

    private Currency currency;

    private GetOrderAddressDto address;
}
