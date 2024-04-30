package com.SpringProject.ECommerce.controllers;

import com.SpringProject.ECommerce.DTOs.RequestDTO.OrderRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.OrderResponseDto;
import com.SpringProject.ECommerce.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity placeOrder(@RequestBody OrderRequestDto orderRequestDto){

        try{
           OrderResponseDto response = orderService.placeOrder(orderRequestDto);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

    // get all the orders for a customer

    // get recent 5 orders

    // delete an order from the order list

    // select the order and also tell the customer name with the highest total value.
