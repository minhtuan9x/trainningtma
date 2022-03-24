package com.dominhtuan.exercise1.service.impl;

import com.dominhtuan.exercise1.converter.UserConverter;
import com.dominhtuan.exercise1.dto.MyUserDetail;
import com.dominhtuan.exercise1.dto.UserDTO;
import com.dominhtuan.exercise1.dto.request.ChangePasswordRequest;
import com.dominhtuan.exercise1.dto.response.UserResponse;
import com.dominhtuan.exercise1.entity.UserEntity;
import com.dominhtuan.exercise1.exception.ChangePasswordException;
import com.dominhtuan.exercise1.repository.UserRepository;
import com.dominhtuan.exercise1.util.SecurityUtil;
import com.dominhtuan.exercise1.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserResponse getUserDetail() {
        UserResponse userResponse = new UserResponse();
        MyUserDetail myUserDetail = SecurityUtil.getPrincipal();
        userResponse.setUserName(myUserDetail.getUsername());
        userResponse.setFullName(myUserDetail.getFullName());
        userResponse.setEmail(myUserDetail.getEmail());
        userResponse.setRoles(SecurityUtil.getAuthorities().stream().map(item -> item.replace("ROLE_", "")).collect(Collectors.joining(",")));
        return userResponse;
    }

    @Override
    @Transactional
    public void insertUser(UserDTO userDTO) {
        userRepository.save(userConverter.toUserEntity(userDTO));
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userConverter::toUserDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(List<Long> userIds) throws NotFoundException {
        if (userRepository.findAllByIdIn(userIds).size() != userIds.size())
            throw new NotFoundException("Not found user!!!");
        userRepository.deleteAllByIdIn(userIds);
    }

    @Override
    public UserDTO findOne(String userName) throws NotFoundException {
        return userConverter.toUserDTO(Optional.ofNullable(userRepository.findByUserName(userName)).orElseThrow(() -> new NotFoundException("Not found user")));
    }

    @Override
    public void updateProfile(UserDTO userDTO) throws NotFoundException {
        userRepository.save(userConverter.toUserEntityUpdate(userDTO));
    }

    @Override
    public void changePassword(ChangePasswordRequest changePasswordRequest) {
        UserEntity userEntity = userRepository.findByUserName(changePasswordRequest.getUserName());
        if(passwordEncoder.matches(changePasswordRequest.getOldPassword(),userEntity.getPassWord())&&changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmNewPassword())){
            userEntity.setPassWord(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
            userRepository.save(userEntity);
        }
        else
            throw new ChangePasswordException("Error when change password");
    }
}
