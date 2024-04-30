package com.SpringProject.ECommerce.Exceptions;

public class InvalidCardException extends RuntimeException{

    public InvalidCardException(String message){
        super(message);
    }
}
