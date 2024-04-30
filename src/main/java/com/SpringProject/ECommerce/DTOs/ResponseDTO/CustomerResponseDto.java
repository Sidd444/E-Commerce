package com.SpringProject.ECommerce.DTOs.ResponseDTO;

import com.SpringProject.ECommerce.enums.Gender;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerResponseDto {

    String name;

    String emailId;

    String mobNo;

    Gender gender;
}
