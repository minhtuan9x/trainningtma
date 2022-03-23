package com.dominhtuan.exercise1.service.impl;

import com.dominhtuan.exercise1.dto.MyUserDetail;
import com.dominhtuan.exercise1.entity.RoleEntity;
import com.dominhtuan.exercise1.entity.UserEntity;
import com.dominhtuan.exercise1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = Optional.ofNullable(userRepository.findByUserName(s)).orElseThrow(()->new UsernameNotFoundException("User Name not found !!!"));
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (RoleEntity item : userEntity.getRoleEntities()) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+item.getCode()));//spring require ROLE_
        }
        return new MyUserDetail(userEntity.getUserName(),userEntity.getPassWord(),true,true,true,true,grantedAuthorities,userEntity.getFullName(),userEntity.getEmail());
    }
}
