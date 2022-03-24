package com.dominhtuan.exercise1.controller.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("HomeControllerOfWeb")
public class HomeController {
    @GetMapping("/user")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("web/home");


        return modelAndView;
    }
}
