package com.example.securitymaster.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.AccessDeniedException;

@Controller
@ControllerAdvice(value = "com.example.securitymaster.controller")
@RequestMapping("/account")
public class AccountController {
    @GetMapping("/accounts")
    public String home(){
        return "account";
    }


    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleErrors(final Throwable throwable, HttpServletResponse response) {

        String errorMessage = (throwable != null ? throwable.getMessage() : "unknown error.");

        System.out.println("=================================== Hello World");
        ModelAndView model = new ModelAndView();

        response.setStatus(HttpStatus.FORBIDDEN.value());
        model.addObject("httpStatus",response.getStatus());
        model.addObject("errorMessage", errorMessage);
        model.addObject("exception",throwable);
        model.setViewName("error1");

        return model;

    }
}
