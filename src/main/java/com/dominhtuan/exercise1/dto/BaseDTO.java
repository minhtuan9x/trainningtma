package com.dominhtuan.exercise1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDTO {
    private Long id;

    public BaseDTO(){

    }
    public BaseDTO(Long id) {
        this.id = id;
    }

}
