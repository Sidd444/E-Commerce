package com.SpringProject.ECommerce.Services;

import com.SpringProject.ECommerce.DTOs.RequestDTO.SellerRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.SellerResponseDto;
import com.SpringProject.ECommerce.Exceptions.EmailAlreadyPresentException;
import com.SpringProject.ECommerce.Models.Seller;
import com.SpringProject.ECommerce.Repositories.SellerRepository;
import com.SpringProject.ECommerce.Transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) {

        // dto -> entity
        Seller seller = SellerTransformer.SellerRequestDtoToSeller(sellerRequestDto);

        // save the entity
        Seller savedSeller = sellerRepository.save(seller);

        // prepare response dto
        return SellerTransformer.SellerToSellerResponseDto(savedSeller);
    }
}