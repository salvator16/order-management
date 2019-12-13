package com.oneflow.interview.ordermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author - ahmet
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StockNotEnoughException extends ContentNotFoundException{
    public StockNotEnoughException(String message) {
        super(message);
    }
}
