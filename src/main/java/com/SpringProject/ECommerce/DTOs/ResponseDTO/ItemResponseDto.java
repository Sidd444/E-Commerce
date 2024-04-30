package com.SpringProject.ECommerce.DTOs.ResponseDTO;

import com.SpringProject.ECommerce.enums.ProductCategory;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ItemResponseDto {

    String itemName;

    int itemPrice;

    int quantityAdded;

    ProductCategory category;
}
