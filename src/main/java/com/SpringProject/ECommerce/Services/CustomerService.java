package com.SpringProject.ECommerce.Services;


import com.SpringProject.ECommerce.DTOs.RequestDTO.CustomerRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.CustomerResponseDto;
import com.SpringProject.ECommerce.Models.*;
import com.SpringProject.ECommerce.Repositories.CustomerRepository;
import com.SpringProject.ECommerce.Transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {

        // dto -> entity
        Customer customer = CustomerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);

        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);
        customer.setCart(cart);

        Customer savedCustomer = customerRepository.save(customer);   // saves both customer and cart;

        // prepare the response dto
        return CustomerTransformer.CustomerToCustomerResponseDto(savedCustomer);

    }
}