package com.dominhtuan.exercise1.converter;

import com.dominhtuan.exercise1.constant.SystemConstant;
import com.dominhtuan.exercise1.dto.UserDTO;
import com.dominhtuan.exercise1.entity.RoleEntity;
import com.dominhtuan.exercise1.entity.UserEntity;
import com.dominhtuan.exercise1.repository.RoleRepository;
import com.dominhtuan.exercise1.repository.UserRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    public UserEntity toUserEntity(UserDTO userDTO){
        UserEntity userEntity = modelMapper.map(userDTO,UserEntity.class);
        userEntity.setPassWord(passwordEncoder.encode(SystemConstant.DEFAULT_PASSWORD));
        userEntity.setRoleEntities(roleRepository.findAllByCodeIn(userDTO.getRoles()));
        return userEntity;
    }
    public UserDTO toUserDTO(UserEntity userEntity){
        UserDTO userDTO = modelMapper.map(userEntity,UserDTO.class);
        userDTO.setRoles(userEntity.getRoleEntities().stream().map(RoleEntity::getCode).collect(Collectors.toList()));
        return userDTO;
    }
    public UserEntity toUserEntityUpdate(UserDTO userDTO) throws NotFoundException {
        UserEntity userEntityFound = userRepository.findById(userDTO.getId()).orElseThrow(()->new NotFoundException("Not found user!!!"));
        userEntityFound.setFullName(userDTO.getFullName());
        userEntityFound.setEmail(userDTO.getEmail());
        return userEntityFound;
    }
}
