package com.SpringProject.ECommerce.Transformer;

import com.SpringProject.ECommerce.DTOs.RequestDTO.SellerRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.SellerResponseDto;
import com.SpringProject.ECommerce.Models.Seller;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerTransformer {

    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){

        return Seller.builder()
                .name(sellerRequestDto.getName())
                .age(sellerRequestDto.getAge())
                .emailId(sellerRequestDto.getEmailId())
                .mobNo(sellerRequestDto.getMobNo())
                .build();
    }

    public static SellerResponseDto SellerToSellerResponseDto(Seller seller){

        return SellerResponseDto.builder()
                .name(seller.getName())
                .age(seller.getAge())
                .build();
    }
}
