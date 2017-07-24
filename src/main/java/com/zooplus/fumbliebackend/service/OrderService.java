package com.zooplus.fumbliebackend.service;

import com.zooplus.fumbliebackend.converter.order.OrderDtoToEntityConverter;
import com.zooplus.fumbliebackend.converter.order.OrderToDtoConverter;
import com.zooplus.fumbliebackend.model.dto.OrderDto;
import com.zooplus.fumbliebackend.model.entity.Order;
import com.zooplus.fumbliebackend.repo.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class OrderService {
    @Resource
    OrderRepository orderRepository;

    @Resource
    OrderToDtoConverter orderToDtoConverter;
    @Resource
    OrderDtoToEntityConverter orderDtoToEntityConverter;

    @Transactional
    public OrderDto placeOrder(OrderDto orderDto) {
        Order order = orderDtoToEntityConverter.convert(orderDto);

        order = orderRepository.save(order);

        return orderToDtoConverter.convert(order);
    }

    public OrderDto findById(long orderId) {
        return orderToDtoConverter.convert(orderRepository.findOne(orderId));
    }
}
