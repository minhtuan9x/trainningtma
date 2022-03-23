package com.dominhtuan.exercise1.controller.admin;

import com.dominhtuan.exercise1.service.BookService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller("bookControllerOfAdmin")
@RequestMapping("/admin/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(required = false) String query) {
        ModelAndView modelAndView = new ModelAndView("admin/book/list");
        modelAndView.addObject("books", bookService.findAll(query));
        modelAndView.addObject("query", query);
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Long id) throws NotFoundException {
        ModelAndView modelAndView = new ModelAndView("admin/book/edit");
        modelAndView.addObject("book", bookService.findOne(id));
        return modelAndView;
    }
}
