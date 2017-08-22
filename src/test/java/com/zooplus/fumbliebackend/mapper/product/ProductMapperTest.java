package com.zooplus.fumbliebackend.mapper.product;

import com.zooplus.fumbliebackend.model.dto.ProductDto;
import com.zooplus.fumbliebackend.model.entity.Product;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ProductMapperTest {

    public static final long PRODUCT_ID = 1L;
    public static final String PRODUCT_TITLE = "product title";
    public static final String PRODUCT_DESCRIPTION = "product description";
    public static final String PRODUCT_LINK_IMAGE = "product link image";
    public static final double PRODUCT_PRICE = 10.99;

    @Test
    public void shouldReturnNull() {
        ProductDto resultProductDto = ProductMapper.INSTANCE.productToProductDto(null);
        Product resultProduct = ProductMapper.INSTANCE.productDtoToProduct(null);

        assertNull(resultProductDto);
        assertNull(resultProduct);
    }

    @Test
    public void shouldMapProductToProductDto() throws Exception {
        Product product = prepareProduct();

        ProductDto productDto = ProductMapper.INSTANCE.productToProductDto(product);

        assertThat(productDto, notNullValue());
        assertThat(productDto.getId(), equalTo(PRODUCT_ID));
        assertThat(productDto.getTitle(), equalTo(PRODUCT_TITLE));
        assertThat(productDto.getDescription(), equalTo(PRODUCT_DESCRIPTION));
        assertThat(productDto.getImage(), equalTo(PRODUCT_LINK_IMAGE));
        assertThat(productDto.getPrice(), equalTo(PRODUCT_PRICE));
    }

    @Test
    public void shouldMapProductDtoToProduct() throws Exception {
        ProductDto productDto = prepareProductDto();

        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);

        assertThat(product, notNullValue());
        assertThat(product.getId(), equalTo(PRODUCT_ID));
        assertThat(product.getTitle(), equalTo(PRODUCT_TITLE));
        assertThat(product.getDescription(), equalTo(PRODUCT_DESCRIPTION));
        assertThat(product.getImage(), equalTo(PRODUCT_LINK_IMAGE));
        assertThat(product.getPrice(), equalTo(PRODUCT_PRICE));
    }

    private Product prepareProduct() {
        Product product = new Product();
        product.setId(PRODUCT_ID);
        product.setTitle(PRODUCT_TITLE);
        product.setDescription(PRODUCT_DESCRIPTION);
        product.setImage(PRODUCT_LINK_IMAGE);
        product.setPrice(PRODUCT_PRICE);
        return product;
    }

    private ProductDto prepareProductDto() {
        ProductDto productDto = new ProductDto();
        productDto.setTitle(PRODUCT_TITLE);
        productDto.setId(PRODUCT_ID);
        productDto.setDescription(PRODUCT_DESCRIPTION);
        productDto.setImage(PRODUCT_LINK_IMAGE);
        productDto.setPrice(PRODUCT_PRICE);
        return productDto;
    }
}