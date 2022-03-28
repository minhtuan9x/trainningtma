package com.dominhtuan.exercise1.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ApiModel(description = "Model Detail user DTO")
public class UserDTO extends BaseDTO{
    @ApiModelProperty(notes = "the unique user name ",required = true)
    private String userName;
    private String fullName;
    private String email;
    private List<String> roles = new ArrayList<>();
}
