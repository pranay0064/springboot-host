package com.javatechie.service;

import com.javatechie.entity.Users;
import com.javatechie.entity.UsersRequest;
import com.javatechie.respository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public String saveUsers(UsersRequest usersRequest){
        Users users=usersRepository.save(Users.builder().name(usersRequest.getName())
                .email(usersRequest.getEmail()).location(usersRequest.getLocation()).build());
        if(users!=null){
            return "data Uploaded successfully";
        }
        return null;
    }

    public List<Users> getUsersInfo(){
        return usersRepository.findAll();
    }
}
