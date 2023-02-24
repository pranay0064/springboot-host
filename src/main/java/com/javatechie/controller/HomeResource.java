package com.javatechie.controller;

import com.javatechie.entity.User;
import com.javatechie.service.MyUserDetailsService;
import com.javatechie.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeResource {

    @Autowired
    MyUserDetailsService userDetailsService;

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
//    @GetMapping("/listuser")
//    public List<User> getsample(){
//        return userDetailsService.getUsers();
//    }
}
