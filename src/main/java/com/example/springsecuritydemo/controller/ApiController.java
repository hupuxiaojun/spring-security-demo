package com.example.springsecuritydemo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {


    @RequestMapping("/test")
    public Object test() {
        return "success";
    }


}
