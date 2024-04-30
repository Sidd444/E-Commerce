package com.SpringProject.ECommerce.DTOs.RequestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemRequestDto {

    String customerEmail;

    int productId;

    int requiredQuantity;
}
