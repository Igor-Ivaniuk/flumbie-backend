package com.zooplus.fumbliebackend.model.dto.getOrder;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel
public class GetOrderProductDto {

    private Long id;
    private String title;
    private String description;
    private String image;
    private Double price;
}
