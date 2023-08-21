package com.SpringProject.ECommerce.DTOs.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class ItemResponseDto {

    String productName;

    int priceOfOneItem;

    int totalPrice;

    int quantity;
}
