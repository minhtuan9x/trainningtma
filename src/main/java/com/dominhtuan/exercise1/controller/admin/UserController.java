package com.dominhtuan.exercise1.controller.admin;

import com.dominhtuan.exercise1.service.RoleService;
import com.dominhtuan.exercise1.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("admin/user/home");
        modelAndView.addObject("users",userService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView edit(){
        ModelAndView modelAndView = new ModelAndView("admin/user/edit");
        modelAndView.addObject("roles",roleService.findAll());
        return modelAndView;
    }
    @GetMapping("/profile/{name}")
    public ModelAndView profile(@PathVariable String name) throws NotFoundException {
        ModelAndView modelAndView = new ModelAndView("admin/user/profile");
        modelAndView.addObject("profile",userService.findOne(name));
        return modelAndView;
    }
    @GetMapping("profile/password")
    public ModelAndView changePassword(){
        ModelAndView modelAndView = new ModelAndView("admin/user/password");
        return modelAndView;
    }
}
