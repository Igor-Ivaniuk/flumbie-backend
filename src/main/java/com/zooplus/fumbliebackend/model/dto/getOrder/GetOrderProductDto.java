package com.zooplus.fumbliebackend.model.dto.getOrder;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetOrderProductDto {

    private Long id;
    private String title;
    private String description;
    private String image;
    private Double price;
}
