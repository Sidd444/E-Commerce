package com.SpringProject.ECommerce.Transformer;

import com.SpringProject.ECommerce.DTOs.RequestDTO.ItemRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.ItemResponseDto;
import com.SpringProject.ECommerce.Models.Item;

public class ItemTransformer {

    public static Item ItemRequestDtoToItem(int requiredQuantity){

        return Item.builder()
                .requiredQuantity(requiredQuantity)
                .build();
    }

    public static ItemResponseDto ItemToItemResponseDto(Item item){

        return ItemResponseDto.builder()
                .itemPrice(item.getProduct().getPrice())
                .itemName(item.getProduct().getProductName())
                .quantityAdded(item.getRequiredQuantity())
                .category(item.getProduct().getProductCategory())
                .build();
    }
}