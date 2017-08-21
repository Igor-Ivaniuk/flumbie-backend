package com.zooplus.fumbliebackend.model.dto.getOrder;

import lombok.Data;

@Data
public class GetOrderOrderItemDto {
    private Long id;

    private GetOrderProductDto product;

    private Integer quantity;

}
