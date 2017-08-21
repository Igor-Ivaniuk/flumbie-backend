package com.zooplus.fumbliebackend.model.dto.placeOrder;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class PlaceOrderOrderItemDto {
    private long productId;

    private Integer quantity;

}
