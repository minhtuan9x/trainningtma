package com.dominhtuan.exercise1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseDTO {
    private Long id;
    private Date createdDate;
    private String createBy;
    private Date modifiedDate;
    private String modifiedBy;

    public BaseDTO(){

    }
    public BaseDTO(Long id) {
        this.id = id;
    }

}
