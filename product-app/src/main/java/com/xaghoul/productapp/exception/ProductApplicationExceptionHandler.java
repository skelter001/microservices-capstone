package com.xaghoul.productapp.exception;

import com.xaghoul.common.exception.EntityNotFoundException;
import com.xaghoul.common.exception.ProductIsUnavailableException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ProductApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({FeignException.NotFound.class})
    protected ResponseEntity<Object> handleFeignException(FeignException ex) {
        logger.error("Handle Feign Exception: {}", ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .message(ex.getMessage())
                        .build());
    }

    @ExceptionHandler({EntityNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        logger.error("Handle Entity Not Found Exception: {}", ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .message(ex.getMessage())
                        .build());

    }

    @ExceptionHandler({ProductIsUnavailableException.class})
    protected ResponseEntity<Object> handleProductIsUnavailableException(ProductIsUnavailableException ex) {
        logger.error("Handle Product Is Unavailable Exception Exception: {}", ex);
        return ResponseEntity
                .badRequest()
                .body(ErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .message(ex.getMessage())
                        .build());

    }
}
