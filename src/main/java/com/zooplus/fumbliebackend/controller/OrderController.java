package com.zooplus.fumbliebackend.controller;

import com.zooplus.fumbliebackend.model.dto.getOrder.GetOrderOrderDto;
import com.zooplus.fumbliebackend.model.dto.placeOrder.PlaceOrderOrderDto;
import com.zooplus.fumbliebackend.service.OrderService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = GetOrderOrderDto.class),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<?> placeOrder(@RequestBody final PlaceOrderOrderDto orderDto) {
        return new ResponseEntity<>(orderService.placeOrder(orderDto), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{orderId}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = GetOrderOrderDto.class),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<?> getOrder(@PathVariable Long orderId) {
        return new ResponseEntity<>(orderService.findById(orderId), HttpStatus.OK);
    }

}
