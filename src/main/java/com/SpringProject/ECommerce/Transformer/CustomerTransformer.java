package com.SpringProject.ECommerce.Transformer;

import com.SpringProject.ECommerce.DTOs.RequestDTO.CustomerRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.CustomerResponseDto;
import com.SpringProject.ECommerce.Models.Customer;

public class CustomerTransformer {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){


        return Customer.builder()
                .age(customerRequestDto.getAge())
                .name(customerRequestDto.getName())
                .address(customerRequestDto.getAddress())
                .emailId(customerRequestDto.getEmailId())
                .mobNo(customerRequestDto.getMobNo())
                .build();
    }

    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){

        return CustomerResponseDto.builder()
                .name(customer.getName())
                .message("Welcome" + customer.getName()+ " to Amazon !!!")
                .build();
    }
}
