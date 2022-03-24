package com.dominhtuan.exercise1.converter;

import com.dominhtuan.exercise1.dto.RoleDTO;
import com.dominhtuan.exercise1.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {
    @Autowired
    private ModelMapper modelMapper;

    public RoleDTO toRoleDTO(RoleEntity roleEntity){
        RoleDTO roleDTO = modelMapper.map(roleEntity,RoleDTO.class);
        return roleDTO;
    }
}
