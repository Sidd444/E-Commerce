package com.SpringProject.ECommerce.controllers;

import com.SpringProject.ECommerce.DTOs.RequestDTO.CustomerRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.CustomerResponseDto;
import com.SpringProject.ECommerce.Exceptions.MobileNoAlreadyPresentException;
import com.SpringProject.ECommerce.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponseDto addCustomer(@RequestBody CustomerRequestDto customerRequestDto) throws MobileNoAlreadyPresentException {

        return customerService.addCustomer(customerRequestDto);
    }

    // view all customers

    // get a customer by email/mob

    // get all customers whose age is greater than 25

    // get all customers who use VISA card

    // update a customer info by email

    // delete a customer by email/mob

}