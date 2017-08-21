package com.zooplus.fumbliebackend.mapper.order;

import com.zooplus.fumbliebackend.model.dto.placeOrder.PlaceOrderAddressDto;
import com.zooplus.fumbliebackend.model.dto.placeOrder.PlaceOrderOrderDto;
import com.zooplus.fumbliebackend.model.entity.Address;
import com.zooplus.fumbliebackend.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Currency;

@Mapper
public interface PlaceOrderMapper {
    PlaceOrderMapper INSTANCE = Mappers.getMapper(PlaceOrderMapper.class);

    Order mapToOrderEntity(PlaceOrderOrderDto dto);

    default Currency mapToCurrency(String value) {
        return Currency.getInstance(value);
    }

    Address mapToAddressEntity(PlaceOrderAddressDto dto);
}
