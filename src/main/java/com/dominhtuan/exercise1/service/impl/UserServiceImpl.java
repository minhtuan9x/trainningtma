package com.dominhtuan.exercise1.service.impl;

import com.dominhtuan.exercise1.dto.MyUserDetail;
import com.dominhtuan.exercise1.dto.response.UserResponse;
import com.dominhtuan.exercise1.security.util.SecurityUtil;
import com.dominhtuan.exercise1.service.UserService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserResponse getUserDetail() {
        UserResponse userResponse = new UserResponse();
        MyUserDetail myUserDetail = SecurityUtil.getPrincipal();
        userResponse.setUserName(myUserDetail.getUsername());
        userResponse.setFullName(myUserDetail.getFullName());
        userResponse.setEmail(myUserDetail.getEmail());
        userResponse.setRoles(SecurityUtil.getAuthorities().stream().map(item->item.replace("ROLE_","")).collect(Collectors.joining(",")));
        return userResponse;
    }
}
