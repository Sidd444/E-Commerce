package com.SpringProject.ECommerce.Transformer;

import java.util.ArrayList;
import java.util.List;

import com.SpringProject.ECommerce.DTOs.ResponseDTO.ItemResponseDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.OrderResponseDto;
import com.SpringProject.ECommerce.Models.Item;
import com.SpringProject.ECommerce.Models.OrderEntity;

public class OrderTransformer {

    public static OrderResponseDto OrderToOrderResponseDto(OrderEntity order){

        List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
        for(Item item: order.getItems()){
            itemResponseDtoList.add(ItemTransformer.ItemToItemResponseDto(item));
        }

        return OrderResponseDto.builder()
                .orderId(order.getOrderId())
                .orderDate(order.getOrderDate())
                .cardUsed(order.getCardUsed())
                .orderTotal(order.getOrderTotal())
                .customerName(order.getCustomer().getName())
                .item(itemResponseDtoList)
                .build();

    }
}
