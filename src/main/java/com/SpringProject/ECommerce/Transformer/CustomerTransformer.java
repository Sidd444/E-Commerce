package com.SpringProject.ECommerce.Transformer;

import java.util.ArrayList;
import java.util.List;

import com.SpringProject.ECommerce.DTOs.RequestDTO.CustomerRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.CartResponseDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.CustomerResponseDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.ItemResponseDto;
import com.SpringProject.ECommerce.Models.Cart;
import com.SpringProject.ECommerce.Models.Customer;
import com.SpringProject.ECommerce.Models.Item;

public class CustomerTransformer {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){

        return Customer.builder()
                .name(customerRequestDto.getName())
                .gender(customerRequestDto.getGender())
                .mobNo(customerRequestDto.getMobNo())
                .emailId(customerRequestDto.getEmailId())
                .build();
    }

    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){

        return CustomerResponseDto.builder()
                .name(customer.getName())
                .gender(customer.getGender())
                .emailId(customer.getEmailId())
                .mobNo(customer.getMobNo())
                .build();
    }
}