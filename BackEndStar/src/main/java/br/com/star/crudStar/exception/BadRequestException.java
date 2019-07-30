package br.com.star.crudStar.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);

    }
}
