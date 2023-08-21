package com.SpringProject.ECommerce.Services;

import com.SpringProject.ECommerce.Transformer.CardTransformer;
import com.SpringProject.ECommerce.Models.Card;
import com.SpringProject.ECommerce.DTOs.RequestDTO.CardRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.CardResponseDto;
import com.SpringProject.ECommerce.Exceptions.InvalidCustomerException;
import com.SpringProject.ECommerce.Models.Customer;
import com.SpringProject.ECommerce.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CustomerRepository customerRepository;

    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws InvalidCustomerException {

        Customer customer = customerRepository.findByMobNo(cardRequestDto.getMobNo());
        if(customer==null){
            throw new InvalidCustomerException("Sorry! The customer doesn't exists");
        }

        Card card = CardTransformer.CardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);

        customer.getCards().add(card);
        customerRepository.save(customer);

        // response dto
        return CardResponseDto.builder()
                .customerName(customer.getName())
                .cardNo(card.getCardNo())
                .build();

    }
}
