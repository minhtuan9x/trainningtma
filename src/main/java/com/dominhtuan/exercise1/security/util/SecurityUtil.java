package com.dominhtuan.exercise1.security.util;

import com.dominhtuan.exercise1.dto.MyUserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.stream.Collectors;

public class SecurityUtil {
    public static MyUserDetail getPrincipal(){
        return (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    public static List<String> getAuthorities(){
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }
}
