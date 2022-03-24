package com.dominhtuan.exercise1.service.impl;

import com.dominhtuan.exercise1.converter.RoleConverter;
import com.dominhtuan.exercise1.dto.RoleDTO;
import com.dominhtuan.exercise1.repository.RoleRepository;
import com.dominhtuan.exercise1.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleConverter roleConverter;

    @Override
    public List<RoleDTO> findAll() {
        return roleRepository.findAll().stream().map(roleConverter::toRoleDTO).collect(Collectors.toList());
    }
}
