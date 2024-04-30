package com.SpringProject.ECommerce.DTOs.RequestDTO;

import com.SpringProject.ECommerce.enums.Gender;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequestDto {

    String name;

    String emailId;

    String mobNo;

    Gender gender;
}