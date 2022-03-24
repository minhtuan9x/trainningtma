package com.dominhtuan.exercise1.security;

import com.dominhtuan.exercise1.constant.SystemConstant;
import com.dominhtuan.exercise1.util.SecurityUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        redirectStrategy.sendRedirect(request,response,determineTargetUrl(SecurityUtil.getAuthorities()));
    }

    private String determineTargetUrl(List<String> roles){
        if(isAdmin(roles))
            return SystemConstant.ADMIN_SUCCESS_HOME;
        if (isUser(roles))
            return SystemConstant.USER_SUCCESS_HOME;
        return null;
    }
    private Boolean isAdmin(List<String> roles){
        return roles.contains(SystemConstant.ADMIN_ROLE)||roles.contains(SystemConstant.STAFF_ROLE);
    }
    private Boolean isUser(List<String> roles){
        return roles.contains(SystemConstant.USER_ROLE);
    }
}
