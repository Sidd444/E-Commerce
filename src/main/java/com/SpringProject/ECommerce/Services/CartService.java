package com.SpringProject.ECommerce.Services;


import com.SpringProject.ECommerce.DTOs.RequestDTO.CheckoutCartRequestDto;
import com.SpringProject.ECommerce.DTOs.RequestDTO.ItemRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.CartResponseDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.ItemResponseDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.OrderResponseDto;
import com.SpringProject.ECommerce.Exceptions.InvalidCardException;
import com.SpringProject.ECommerce.Exceptions.CustomerNotFoundException;
import com.SpringProject.ECommerce.Exceptions.EmptyCartException;
import com.SpringProject.ECommerce.Models.*;
import com.SpringProject.ECommerce.Repositories.CardRespository;
import com.SpringProject.ECommerce.Repositories.CartRepository;
import com.SpringProject.ECommerce.Repositories.CustomerRepository;
import com.SpringProject.ECommerce.Repositories.ItemRepository;
import com.SpringProject.ECommerce.Repositories.OrderEntityRepository;
import com.SpringProject.ECommerce.Repositories.ProductRepository;
import com.SpringProject.ECommerce.Transformer.CartTransformer;
import com.SpringProject.ECommerce.Transformer.ItemTransformer;
import com.SpringProject.ECommerce.Transformer.OrderTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CardRespository cardRespository;

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderService orderService;
    @Autowired
    private OrderEntityRepository orderEntityRepository;

    public CartResponseDto addItemToCart(ItemRequestDto itemRequestDto,Item item) {

        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmail());
        Product product = productRepository.findById(itemRequestDto.getProductId()).get();

        Cart cart = customer.getCart();
        cart.setCartTotal(cart.getCartTotal() + product.getPrice()*itemRequestDto.getRequiredQuantity());

        item.setCart(cart);
        item.setProduct(product);
        Item savedItem = itemRepository.save(item);  // to avoid duplicacy

        cart.getItems().add(savedItem);
        product.getItems().add(savedItem);
        Cart savedCart = cartRepository.save(cart);
        productRepository.save(product);

        //prepare cartResponse Dto
        return CartTransformer.CartToCartReponseDto(savedCart);

    }

    public OrderResponseDto checkoutCart(CheckoutCartRequestDto checkoutCartRequestDto) {

        Customer customer = customerRepository.findByEmailId(checkoutCartRequestDto.getCustomerEmail());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exist");
        }

        Card card = cardRespository.findByCardNo(checkoutCartRequestDto.getCardNo());
        Date currentDate = new Date();
        if(card==null || card.getCvv()!= checkoutCartRequestDto.getCvv() || currentDate.after(card.getValidTill())){
            throw new InvalidCardException("Card is not valid");
        }

        Cart cart = customer.getCart();
        if(cart.getItems().size()==0){
            throw new EmptyCartException("Sorry! The cart is empty");
        }

        OrderEntity order = orderService.placeOrder(cart,card);
        resetCart(cart);

        OrderEntity savedOrder = orderEntityRepository.save(order);

        // prepare response dto
        return OrderTransformer.OrderToOrderResponseDto(savedOrder);
    }

    public void resetCart(Cart cart){

        cart.setCartTotal(0);
        for(Item item: cart.getItems()){
            item.setCart(null);
        }
        cart.setItems(new ArrayList<>());

    }
}