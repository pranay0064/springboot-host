package com.javatechie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class MessageController {
    @GetMapping
    public String getData(){
        return ("<h2>Hello</h2>");
    }

    @GetMapping("/user-msg")
    public String getUserData(){
        return ("<h2>Hello User</h2>");
    }
    @GetMapping("/admin-msg")
    public String getAdminData(){
        return ("<h2>Hello Admin</h2>");
    }
}
