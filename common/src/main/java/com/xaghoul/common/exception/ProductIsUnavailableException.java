package com.xaghoul.common.exception;

import com.xaghoul.common.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class ProductIsUnavailableException extends RuntimeException {

    public ProductIsUnavailableException(String id) {
        super("Product with id " + id + " is not unavailable");
    }
}

