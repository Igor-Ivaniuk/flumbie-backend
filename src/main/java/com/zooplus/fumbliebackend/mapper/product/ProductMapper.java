package com.zooplus.fumbliebackend.mapper.product;

import com.zooplus.fumbliebackend.model.dto.ProductDto;
import com.zooplus.fumbliebackend.model.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToProductDto(Product product);

    @InheritInverseConfiguration
    Product productDtoToProduct(ProductDto productDto);

}
