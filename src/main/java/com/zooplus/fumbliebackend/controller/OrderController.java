package com.zooplus.fumbliebackend.controller;

import com.zooplus.fumbliebackend.model.dto.placeOrder.PlaceOrderOrderDto;
import com.zooplus.fumbliebackend.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;


    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> placeOrder(@RequestBody final PlaceOrderOrderDto orderDto) {
        return new ResponseEntity<>(orderService.placeOrder(orderDto), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{orderId}", produces = "application/json")
    public ResponseEntity<?> getOrder(@PathVariable Long orderId) {
        return new ResponseEntity<>(orderService.findById(orderId), HttpStatus.OK);
    }

}
