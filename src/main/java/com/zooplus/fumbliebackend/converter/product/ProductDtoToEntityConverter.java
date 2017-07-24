package com.zooplus.fumbliebackend.converter.product;

import com.zooplus.fumbliebackend.model.dto.ProductDto;
import com.zooplus.fumbliebackend.model.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoToEntityConverter implements Converter<ProductDto, Product> {
    @Override
    public Product convert(final ProductDto dto) {
        if (dto == null) return null;

        Product product = new Product();

        product.setId(dto.getId());
        product.setDescription(dto.getDescription());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());

        return product;
    }
}
