package com.xaghoul.productapp.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ErrorResponse {

    private final LocalDateTime timestamp;
    private final String message;
}
