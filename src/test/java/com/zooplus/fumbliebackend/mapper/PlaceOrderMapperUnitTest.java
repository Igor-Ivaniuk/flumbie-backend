package com.zooplus.fumbliebackend.mapper;


import com.zooplus.fumbliebackend.mapper.order.PlaceOrderMapper;
import com.zooplus.fumbliebackend.model.dto.placeOrder.PlaceOrderAddressDto;
import com.zooplus.fumbliebackend.model.dto.placeOrder.PlaceOrderOrderDto;
import com.zooplus.fumbliebackend.model.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaceOrderMapperUnitTest {
    private static final String TEST_NAME = "testName";
    private static final BigDecimal TEST_TOTAL_AMOUNT = BigDecimal.valueOf(1.33);
    private static final String TEST_CURRENCY_CODE = "EUR";
    @Test
    public void shouldMapToEntity() {
        //given
        PlaceOrderOrderDto placeOrderOrderDto = new PlaceOrderOrderDto();
        PlaceOrderAddressDto placeOrderAddressDto = new PlaceOrderAddressDto();

        placeOrderOrderDto.setTotalAmount(TEST_TOTAL_AMOUNT);
        placeOrderOrderDto.setCurrency(TEST_CURRENCY_CODE);
        placeOrderAddressDto.setName(TEST_NAME);

        placeOrderOrderDto.setAddress(placeOrderAddressDto);

        //when
        Order order = PlaceOrderMapper.INSTANCE.mapToOrderEntity(placeOrderOrderDto);

        //then
        assertThat(order).isNotNull();
        assertThat(order.getTotalAmount()).isEqualByComparingTo(placeOrderOrderDto.getTotalAmount());
        assertThat(order.getAddress().getName()).isEqualTo(placeOrderOrderDto.getAddress().getName());
    }
}
