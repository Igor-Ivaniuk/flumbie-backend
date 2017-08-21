package com.zooplus.fumbliebackend.mapper.order;

import com.zooplus.fumbliebackend.model.dto.getOrder.GetOrderOrderDto;
import com.zooplus.fumbliebackend.model.entity.Address;
import com.zooplus.fumbliebackend.model.entity.Order;
import com.zooplus.fumbliebackend.model.entity.OrderItem;
import com.zooplus.fumbliebackend.model.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetOrderMapperUnitTest {

    private static final String PRODUCT_1_TITLE = "Produkt1";
    private static final String PROCDUCT_2_TITLE = "Procduct2";
    private static final String TESTNAME = "Testname";

    @Before
    public void setup() {


    }

    @Test
    public void shouldMapEntityToDto() {
        //given
        Order order = new Order();
        Address address = new Address();
        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();
        Product product1 = new Product();
        Product product2 = new Product();

        address.setName(TESTNAME);

        product1.setTitle(PRODUCT_1_TITLE);
        product2.setTitle(PROCDUCT_2_TITLE);

        orderItem1.setProduct(product1);
        orderItem1.setQuantity(1);
        orderItem2.setProduct(product2);
        orderItem2.setQuantity(2);

        order.setOrderItems(new ArrayList<OrderItem>() {
            {
                add(orderItem1);
                add(orderItem2);
            }
        });
        order.setAddress(address);

        //when
        GetOrderOrderDto orderDto = GetOrderMapper.INSTANCE.mapOrderFromEntity(order);

        //then
        assertThat(orderDto).isNotNull();
        assertThat(orderDto.getAddress().getName()).isEqualTo(order.getAddress().getName());
        assertThat(orderDto.getOrderItems().size()).isEqualTo(2);
        assertThat(orderDto.getOrderItems().get(0).getQuantity()).isEqualTo(order.getOrderItems().get(0).getQuantity());
        assertThat(orderDto.getOrderItems().get(0).getProduct().getTitle()).isEqualTo(order.getOrderItems().get(0).getProduct().getTitle());
    }
}
