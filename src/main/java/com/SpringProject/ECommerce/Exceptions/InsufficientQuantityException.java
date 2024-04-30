package com.SpringProject.ECommerce.Exceptions;

public class InsufficientQuantityException extends RuntimeException{

    public InsufficientQuantityException(String message){
        super(message);
    }
}