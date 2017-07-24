package com.zooplus.fumbliebackend.converter.product;

import com.zooplus.fumbliebackend.model.dto.ProductDto;
import com.zooplus.fumbliebackend.model.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductDtoConverter implements Converter<Product, ProductDto> {

    @Override
    public ProductDto convert(final Product product) {
        if (product == null) {
            return null;
        }

        return getProductInformation(product);
    }

    private ProductDto getProductInformation(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setImage(product.getImage());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
}
