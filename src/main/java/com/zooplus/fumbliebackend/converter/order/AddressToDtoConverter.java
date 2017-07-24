package com.zooplus.fumbliebackend.converter.order;

import com.zooplus.fumbliebackend.model.dto.AddressDto;
import com.zooplus.fumbliebackend.model.entity.Address;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressToDtoConverter implements Converter<Address, AddressDto> {
    @Override
    public AddressDto convert(final Address address) {
        if (address == null) return null;

        AddressDto dto = new AddressDto();

        dto.setName(address.getName());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setZipCode(address.getZipCode());
        dto.setCountry(address.getCountry());

        return dto;
    }
}
