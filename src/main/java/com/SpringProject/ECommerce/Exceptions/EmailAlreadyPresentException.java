package com.SpringProject.ECommerce.Exceptions;

public class EmailAlreadyPresentException extends Exception{

    public EmailAlreadyPresentException(String message){
        super(message);
    }
}
