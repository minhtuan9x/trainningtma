package com.dominhtuan.exercise1.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class JwtResponse {
    private String token;
    private String username;
    private String email;
    private String fullName;
    private List<String> roles;

    JwtResponse(){

    }

    public JwtResponse(String token, String username, String email, String fullName, List<String> roles) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.roles = roles;
    }
}
