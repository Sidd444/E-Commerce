package com.SpringProject.ECommerce.Exceptions;

public class SellerNotFoundException extends RuntimeException{

    public SellerNotFoundException(String message){
        super(message);
    }
}
