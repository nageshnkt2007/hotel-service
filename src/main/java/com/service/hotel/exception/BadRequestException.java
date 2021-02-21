package com.service.hotel.exception;

public class BadRequestException extends Exception {
    public BadRequestException(String body){
        super(body);
    }

    public BadRequestException(String body, Throwable ex){
        super(body,ex);
    }
}
