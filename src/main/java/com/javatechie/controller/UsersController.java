package com.javatechie.controller;

import com.javatechie.entity.Users;
import com.javatechie.entity.UsersRequest;
import com.javatechie.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping
    public String sendData(@RequestBody UsersRequest usersRequest){
        return usersService.saveUsers(usersRequest);
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return usersService.getUsersInfo();
    }
}
