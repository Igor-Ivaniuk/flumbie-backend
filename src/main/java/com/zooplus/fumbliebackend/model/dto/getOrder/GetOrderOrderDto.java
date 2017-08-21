package com.zooplus.fumbliebackend.model.dto.getOrder;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Data
@ApiModel
public class GetOrderOrderDto {
    private Long id;

    private List<GetOrderOrderItemDto> orderItems;

    private BigDecimal totalAmount;

    private Currency currency;

    private GetOrderAddressDto address;
}
