package com.SpringProject.ECommerce.Transformer;

import com.SpringProject.ECommerce.DTOs.RequestDTO.ProductRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.ProductResponseDto;
import com.SpringProject.ECommerce.Models.Product;
import com.SpringProject.ECommerce.enums.ProductStatus;

public class ProductTransformer {

    public static Product ProductRequestDtoToProduct(ProductRequestDto productRequestDto){

        return Product.builder()
                .name(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .productCategory(productRequestDto.getProductCategory())
                .quantity(productRequestDto.getQuantity())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }

    public static ProductResponseDto ProductToProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .productName(product.getName())
                .sellerName(product.getSeller().getName())
                .quantity(product.getQuantity())
                .productStatus(product.getProductStatus())
                .build();
    }
}
