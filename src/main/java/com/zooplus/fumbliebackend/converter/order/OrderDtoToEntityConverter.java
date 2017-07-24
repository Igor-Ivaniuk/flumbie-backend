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
public class OrderDtoToEntityConverter implements Converter<OrderDto, Order> {

    @Resource
    private AddressDtoToEntityConverter addressDtoToEntityConverter;
    @Resource
    private OrderItemDtoToEntityConverter orderItemDtoToEntityConverter;

    @Override
    public Order convert(final OrderDto dto) {
        if (dto == null) return null;

        Order order = new Order();

        order.setId(dto.getId());
        order.setTotalAmount(dto.getTotalAmount());
        order.setCurrency(dto.getCurrency());
        order.setAddress(addressDtoToEntityConverter.convert(dto.getAddress()));
        order.setOrderItems(convertOrderItems(dto.getOrderItems()));

        return order;
    }

    private List<OrderItem> convertOrderItems(List<OrderItemDto> dtoList) {
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDto dto : dtoList) {
            orderItems.add(orderItemDtoToEntityConverter.convert(dto));
        }

        return orderItems;

    }
}
