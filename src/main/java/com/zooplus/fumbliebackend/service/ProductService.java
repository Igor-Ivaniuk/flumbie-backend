package com.zooplus.fumbliebackend.service;


import com.zooplus.fumbliebackend.error.exception.InvalidProductIdException;
import com.zooplus.fumbliebackend.error.exception.ProductNotFoundException;
import com.zooplus.fumbliebackend.mapper.product.ProductMapper;
import com.zooplus.fumbliebackend.message.product.ProductResponse;
import com.zooplus.fumbliebackend.message.product.ProductsResponse;
import com.zooplus.fumbliebackend.model.dto.ProductDto;
import com.zooplus.fumbliebackend.model.entity.Product;
import com.zooplus.fumbliebackend.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductRepo productRepo;

    public ProductsResponse getAllProducts(){
        List<Product> products = (List<Product>) productRepo.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        for(Product product : products)
            productDtos.add(ProductMapper.INSTANCE.productToProductDto(product));

        ProductsResponse response = new ProductsResponse();
        response.setProducts(productDtos);

        return response;
    }

    public ProductResponse getProductById(String productId){

        Long id;
        try {
            id = Long.parseLong(productId);
        } catch (NumberFormatException e) {
            throw new InvalidProductIdException(productId);
        }

        Product product = productRepo.findOne(id);

        if(product != null)
            return new ProductResponse(ProductMapper.INSTANCE.productToProductDto(product));

        throw new ProductNotFoundException(productId);
    }
}
