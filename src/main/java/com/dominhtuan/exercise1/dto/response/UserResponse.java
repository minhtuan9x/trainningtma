package com.dominhtuan.exercise1.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private String userName;
    private String fullName;
    private String email;
    private String roles;
}
