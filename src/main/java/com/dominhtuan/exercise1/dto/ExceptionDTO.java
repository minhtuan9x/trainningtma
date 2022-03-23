package com.dominhtuan.exercise1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDTO {
    private String status;
    private String message;

    public ExceptionDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
