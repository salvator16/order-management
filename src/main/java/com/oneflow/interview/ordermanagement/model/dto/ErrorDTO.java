package com.oneflow.interview.ordermanagement.model.dto;

import java.util.Objects;

/**
 * @author - ahmet
 */

public class ErrorDTO {

    private String message;

    public ErrorDTO() {
    }

    public ErrorDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorDTO)) return false;
        ErrorDTO errorDTO = (ErrorDTO) o;
        return getMessage().equals(errorDTO.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessage());
    }
}
