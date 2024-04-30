package com.SpringProject.ECommerce.DTOs.RequestDTO;

import com.SpringProject.ECommerce.enums.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardRequestDto {

    String customerMobile;

    String cardNo;

    int cvv;

    Date validTill;

    CardType cardType;
}
