package com.dominhtuan.exercise1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDTO extends BaseDTO{
    private String userName;
    private String fullName;
    private String email;
    private List<String> roles = new ArrayList<>();
}
