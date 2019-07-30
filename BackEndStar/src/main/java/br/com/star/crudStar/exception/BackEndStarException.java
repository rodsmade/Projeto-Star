package br.com.star.crudStar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BackEndStarException extends RuntimeException {
    public BackEndStarException(String message) {
            super(message);
        }

    }


