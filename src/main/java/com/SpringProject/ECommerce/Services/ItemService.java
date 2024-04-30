package com.SpringProject.ECommerce.Services;


import com.SpringProject.ECommerce.DTOs.RequestDTO.ItemRequestDto;
import com.SpringProject.ECommerce.Exceptions.CustomerNotFoundException;
import com.SpringProject.ECommerce.Exceptions.InsufficientQuantityException;
import com.SpringProject.ECommerce.Exceptions.ProductNotFoundException;
import com.SpringProject.ECommerce.Models.*;
import com.SpringProject.ECommerce.Repositories.CustomerRepository;
import com.SpringProject.ECommerce.Repositories.ItemRepository;
import com.SpringProject.ECommerce.Repositories.ProductRepository;
import com.SpringProject.ECommerce.Transformer.ItemTransformer;
import com.SpringProject.ECommerce.enums.ProductStatus;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ItemService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;
    public Item createItem(ItemRequestDto itemRequestDto) {

        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmail());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exisit");
        }

        Optional<Product> productOptional = productRepository.findById(itemRequestDto.getProductId());
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product doesn't exist");
        }

        Product product = productOptional.get();

        // check for required quantity
        if(product.getAvailableQuantity()< itemRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("Sorry! Required quantity not avaiable");
        }

        // create item
        Item item = ItemTransformer.ItemRequestDtoToItem(itemRequestDto.getRequiredQuantity());
        return item;
    }
}