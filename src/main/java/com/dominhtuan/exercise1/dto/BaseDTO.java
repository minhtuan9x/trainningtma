package com.dominhtuan.exercise1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseDTO {
    @ApiModelProperty(notes = "the unique id")
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
