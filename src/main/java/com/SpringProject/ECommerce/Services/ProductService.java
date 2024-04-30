package com.SpringProject.ECommerce.Services;

import java.util.ArrayList;

import com.SpringProject.ECommerce.DTOs.RequestDTO.ProductRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.ProductResponseDto;
import com.SpringProject.ECommerce.Exceptions.SellerNotFoundException;
import com.SpringProject.ECommerce.Models.*;
import com.SpringProject.ECommerce.Repositories.CustomerRepository;
import com.SpringProject.ECommerce.Repositories.ProductRepository;
import com.SpringProject.ECommerce.Repositories.SellerRepository;
import com.SpringProject.ECommerce.Transformer.ProductTransformer;
import com.SpringProject.ECommerce.enums.ProductCategory;
import com.SpringProject.ECommerce.enums.ProductStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {

        Seller seller = sellerRepository.findByEmailId(productRequestDto.getSellerEmail());
        if (seller == null) {
            throw new SellerNotFoundException("Seller doesn't exist");
        }

        // dto -> entity
        Product product = ProductTransformer.ProductRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);
        seller.getProducts().add(product);

        Seller savedSeller = sellerRepository.save(seller); // save both product and seller
        List<Product> productList = savedSeller.getProducts();
        Product latestProduct = productList.get(productList.size() - 1);

        // prepare response dto
        return ProductTransformer.ProductToProductResponseDto(latestProduct);
    }

    public List<ProductResponseDto> getProdByCategoryAndPriceGreaterThan(int price,
                                                                         ProductCategory category) {

        List<Product> products = productRepository.getProdByCategoryAndPriceGreaterThan(price,category);

        // prepare list of response dtos
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product: products){
            productResponseDtos.add(ProductTransformer.ProductToProductResponseDto(product));
        }

        return productResponseDtos;

    }
}