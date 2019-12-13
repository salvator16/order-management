package com.oneflow.interview.ordermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author - ahmet
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductAlreadyExistException extends BadRequestException {
    public ProductAlreadyExistException(String message) {
        super(message);
    }
}
