package com.SpringProject.ECommerce.DTOs.ResponseDTO;

import java.util.Date;

import com.SpringProject.ECommerce.enums.CardType;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardResponseDto {

    String customerName;

    String cardNo;  // masked

    Date validTill;

    CardType cardType;
}
