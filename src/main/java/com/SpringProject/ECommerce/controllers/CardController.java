package com.SpringProject.ECommerce.controllers;


import com.SpringProject.ECommerce.DTOs.RequestDTO.CardRequestDto;
import com.SpringProject.ECommerce.DTOs.ResponseDTO.CardResponseDto;
import com.SpringProject.ECommerce.Exceptions.CustomerNotFoundException;
import com.SpringProject.ECommerce.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody CardRequestDto cardRequestDto){

        try{
            CardResponseDto cardResponseDto = cardService.addCard(cardRequestDto);
            return new ResponseEntity(cardResponseDto, HttpStatus.CREATED);
        }
        catch (CustomerNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}

    // get all VISA cards

    // get all MASTERCARD cards whose expirt is greater than 1 Jan 2025

    // Return the CardType which has maximum number of that card


