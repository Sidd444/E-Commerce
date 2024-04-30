package com.SpringProject.ECommerce.controllers;


import com.SpringProject.ECommerce.DTOs.RequestDTO.CheckoutCartRequestDto;
import com.SpringProject.ECommerce.DTOs.RequestDTO.ItemRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.CartResponseDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.OrderResponseDto;
import com.SpringProject.ECommerce.Models.Item;
import com.SpringProject.ECommerce.Repositories.CartRepository;
import com.SpringProject.ECommerce.Services.CartService;
import com.SpringProject.ECommerce.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ItemService itemService;

    @Autowired
    CartService cartService;

    @Autowired
    CartRepository cartRepository;

    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody ItemRequestDto itemRequestDto){

        try{
          Item item = itemService.createItem(itemRequestDto);
          CartResponseDto cartResponseDto = cartService.addItemToCart(itemRequestDto,item);
          return new ResponseEntity(cartResponseDto,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/checkout")
    public ResponseEntity checkoutCart(@RequestBody CheckoutCartRequestDto checkoutCartRequestDto){

        try{
          OrderResponseDto response = cartService.checkoutCart(checkoutCartRequestDto);
          return new ResponseEntity(response,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
    // remove from cart

    // view all items in cart

    // email sending

    // my email - kunaljindal995@gmail.com


