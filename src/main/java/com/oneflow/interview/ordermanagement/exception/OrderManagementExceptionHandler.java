package com.oneflow.interview.ordermanagement.exception;

import com.oneflow.interview.ordermanagement.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author - ahmet
 */
@ControllerAdvice
public class OrderManagementExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     *  HTTP status code NOT_FOUND (404)
     *
     * @param e Exception to be handled
     * @return {@link ErrorDTO} containing the error message
     */
    @ExceptionHandler(ContentNotFoundException.class)
    public ResponseEntity<ErrorDTO> contentNotFoundException(ContentNotFoundException e) {
        final ErrorDTO error = new ErrorDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /**
     *  HTTP status code BAD_REQUEST (400)
     *
     * @param e Exception to be handled
     * @return {@link ErrorDTO} containing the error message
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDTO> BadRequestException(BadRequestException e) {
        final ErrorDTO error = new ErrorDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * HTTP status code INTERNAL_SERVER_ERROR (500)
     *
     * @param e Exception to be handled
     * @return {@link ErrorDTO} containing the error message
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorDTO> throwableException(Throwable e) {
        final ErrorDTO error = new ErrorDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}
