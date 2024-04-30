package com.SpringProject.ECommerce.DTOs.RequestDTO;

import com.SpringProject.ECommerce.enums.ProductCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequestDto {

    String sellerEmail;

    String productName;

    int price;

    int availableQuantity;

    ProductCategory category;
}
