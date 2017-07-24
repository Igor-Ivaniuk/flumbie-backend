package com.zooplus.fumbliebackend.converter.order;

import com.zooplus.fumbliebackend.converter.product.ProductDtoToEntityConverter;
import com.zooplus.fumbliebackend.model.dto.OrderItemDto;
import com.zooplus.fumbliebackend.model.entity.OrderItem;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class OrderItemDtoToEntityConverter implements Converter<OrderItemDto, OrderItem> {
    @Resource
    ProductDtoToEntityConverter productDtoToEntityConverter;

    @Override
    public OrderItem convert(final OrderItemDto dto) {
        if (dto == null) return null;

        OrderItem orderItem = new OrderItem();

        orderItem.setId(dto.getId());
        orderItem.setProduct(productDtoToEntityConverter.convert(dto.getProduct()));
        orderItem.setQuantity(dto.getQuantity());

        return orderItem;
    }
}
