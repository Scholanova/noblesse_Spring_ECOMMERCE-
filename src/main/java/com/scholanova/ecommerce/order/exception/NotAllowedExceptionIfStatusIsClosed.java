package com.scholanova.ecommerce.order.exception;

public class NotAllowedExceptionIfStatusIsClosed extends Exception{
    public NotAllowedExceptionIfStatusIsClosed(String message) {
        super(message);
    }
}
