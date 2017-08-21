package com.zooplus.fumbliebackend.model.dto.getOrder;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class GetOrderOrderItemDto {
    private Long id;

    private GetOrderProductDto product;

    private Integer quantity;

}
