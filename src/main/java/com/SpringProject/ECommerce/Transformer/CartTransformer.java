package com.SpringProject.ECommerce.Transformer;

import java.util.ArrayList;
import java.util.List;

import com.SpringProject.ECommerce.DTOs.ResponseDTO.CartResponseDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.ItemResponseDto;
import com.SpringProject.ECommerce.Models.Cart;
import com.SpringProject.ECommerce.Models.Item;

public class CartTransformer {

    public static CartResponseDto CartToCartReponseDto(Cart cart){

        List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
        for(Item item: cart.getItems()){
            itemResponseDtoList.add(ItemTransformer.ItemToItemResponseDto(item));
        }

        return CartResponseDto.builder()
                .cartTotal(cart.getCartTotal())
                .customerName(cart.getCustomer().getName())
                .items(itemResponseDtoList)
                .build();
    }
}