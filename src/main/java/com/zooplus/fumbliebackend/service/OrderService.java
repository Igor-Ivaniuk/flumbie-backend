package com.zooplus.fumbliebackend.service;

import com.zooplus.fumbliebackend.mapper.order.GetOrderMapper;
import com.zooplus.fumbliebackend.mapper.order.PlaceOrderMapper;
import com.zooplus.fumbliebackend.model.dto.getOrder.GetOrderOrderDto;
import com.zooplus.fumbliebackend.model.dto.placeOrder.PlaceOrderOrderDto;
import com.zooplus.fumbliebackend.model.entity.Order;
import com.zooplus.fumbliebackend.repo.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class OrderService {
    @Resource
    OrderRepository orderRepository;

    @Transactional
    public GetOrderOrderDto placeOrder(PlaceOrderOrderDto orderDto) {
        Order order = PlaceOrderMapper.INSTANCE.mapToOrderEntity(orderDto);

        order = orderRepository.save(order);

        return GetOrderMapper.INSTANCE.mapOrderFromEntity(order);
    }

    public GetOrderOrderDto findById(long orderId) {
        return GetOrderMapper.INSTANCE.mapOrderFromEntity(orderRepository.findOne(orderId));
    }
}
