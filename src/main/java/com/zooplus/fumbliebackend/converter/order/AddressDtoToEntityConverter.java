package com.zooplus.fumbliebackend.converter.order;

import com.zooplus.fumbliebackend.model.dto.AddressDto;
import com.zooplus.fumbliebackend.model.entity.Address;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoToEntityConverter implements Converter<AddressDto, Address> {
    @Override
    public Address convert(final AddressDto dto) {
        if (dto == null) return null;

        Address address = new Address();

        address.setName(dto.getName());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setZipCode(dto.getZipCode());
        address.setCountry(dto.getCountry());

        return address;
    }
}
