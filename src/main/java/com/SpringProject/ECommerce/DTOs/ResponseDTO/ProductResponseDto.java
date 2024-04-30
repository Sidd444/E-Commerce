package com.SpringProject.ECommerce.DTOs.ResponseDTO;


import com.SpringProject.ECommerce.enums.ProductCategory;
import com.SpringProject.ECommerce.enums.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {

    String sellerName;

    String productName;

    int price;

    int availableQuantity;

    ProductCategory category;

    ProductStatus productStatus;
}