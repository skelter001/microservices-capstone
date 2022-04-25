package com.xaghoul.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductIsUnavailableException extends RuntimeException {

    public ProductIsUnavailableException(String id) {
        super("Product with id " + id + " is not unavailable");
    }
}

