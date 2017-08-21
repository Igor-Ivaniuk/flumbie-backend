package com.zooplus.fumbliebackend.mapper.order;

import com.zooplus.fumbliebackend.model.dto.getOrder.GetOrderAddressDto;
import com.zooplus.fumbliebackend.model.dto.getOrder.GetOrderOrderDto;
import com.zooplus.fumbliebackend.model.dto.getOrder.GetOrderOrderItemDto;
import com.zooplus.fumbliebackend.model.dto.getOrder.GetOrderProductDto;
import com.zooplus.fumbliebackend.model.entity.Address;
import com.zooplus.fumbliebackend.model.entity.Order;
import com.zooplus.fumbliebackend.model.entity.OrderItem;
import com.zooplus.fumbliebackend.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GetOrderMapper {
    GetOrderMapper INSTANCE = Mappers.getMapper(GetOrderMapper.class);

    GetOrderOrderDto mapOrderFromEntity(Order order);

    GetOrderOrderItemDto mapOrderItemFromEntity(OrderItem orderItem);

    GetOrderAddressDto mapAddressFromEntity(Address address);

    GetOrderProductDto mapProductFromEntity(Product product);
}
