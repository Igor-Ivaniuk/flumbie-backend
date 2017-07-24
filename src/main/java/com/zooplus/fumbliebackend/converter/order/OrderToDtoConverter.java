package com.zooplus.fumbliebackend.converter.order;

import com.zooplus.fumbliebackend.model.dto.OrderDto;
import com.zooplus.fumbliebackend.model.dto.OrderItemDto;
import com.zooplus.fumbliebackend.model.entity.Order;
import com.zooplus.fumbliebackend.model.entity.OrderItem;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderToDtoConverter implements Converter<Order, OrderDto> {

    @Resource
    OrderItemToDtoConverter orderItemToDtoConverter;
    @Resource
    AddressToDtoConverter addressToDtoConverter;

    @Override
    public OrderDto convert(final Order order) {
        if (order == null) return null;

        OrderDto dto = new OrderDto();

        dto.setId(order.getId());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setCurrency(order.getCurrency());
        dto.setOrderItems(convertOrderItems(order.getOrderItems()));
        dto.setAddress(addressToDtoConverter.convert(order.getAddress()));

        return dto;
    }

    private List<OrderItemDto> convertOrderItems(List<OrderItem> orderItems) {
        List<OrderItemDto> orderItemDtos = new ArrayList<>();

        for (OrderItem item : orderItems) {
            orderItemDtos.add(orderItemToDtoConverter.convert(item));
        }
        return orderItemDtos;
    }
}
