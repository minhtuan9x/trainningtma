package com.dominhtuan.exercise1.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public ModelAndView home(){
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public ModelAndView loginPage(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
    @GetMapping("/access-denied")
    public ModelAndView accessDenied(){
        ModelAndView modelAndView = new ModelAndView("accessdenied");
        return modelAndView;
    }
}
