package com.spengergasse.exceptions;

public class InvalidPaymentException extends Exception{
    public InvalidPaymentException(String message) {
        super(message);
    }
}
