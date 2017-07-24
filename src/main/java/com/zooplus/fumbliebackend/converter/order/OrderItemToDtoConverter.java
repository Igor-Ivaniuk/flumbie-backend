package com.zooplus.fumbliebackend.converter.order;

import com.zooplus.fumbliebackend.converter.product.ProductToProductDtoConverter;
import com.zooplus.fumbliebackend.model.dto.OrderItemDto;
import com.zooplus.fumbliebackend.model.entity.OrderItem;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class OrderItemToDtoConverter implements Converter<OrderItem, OrderItemDto> {
    @Resource
    ProductToProductDtoConverter productToProductDtoConverter;

    @Override
    public OrderItemDto convert(final OrderItem orderItem) {
        if (orderItem == null) return null;

        OrderItemDto dto = new OrderItemDto();

        dto.setId(orderItem.getId());
        dto.setProduct(productToProductDtoConverter.convert(orderItem.getProduct()));
        dto.setQuantity(orderItem.getQuantity());

        return dto;
    }
}
