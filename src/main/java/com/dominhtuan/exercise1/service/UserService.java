package com.dominhtuan.exercise1.service;

import com.dominhtuan.exercise1.dto.UserDTO;
import com.dominhtuan.exercise1.dto.request.ChangePasswordRequest;
import com.dominhtuan.exercise1.dto.response.UserResponse;
import javassist.NotFoundException;

import java.util.List;

public interface UserService {
    UserResponse getUserDetail();

    void insertUser(UserDTO userDTO);
    List<UserDTO> findAll();
    void delete(List<Long> userIds) throws NotFoundException;
    UserDTO findOne(String userName) throws NotFoundException;
    void updateProfile(UserDTO userDTO) throws NotFoundException;
    void changePassword(ChangePasswordRequest changePasswordRequest);
    void resetPassword(String userName) throws NotFoundException;
}
