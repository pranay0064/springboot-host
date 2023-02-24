package com.javatechie.service;

import com.javatechie.entity.MyUserDetails;
import com.javatechie.entity.TrailDetails;
import com.javatechie.entity.User;
import com.javatechie.entity.Users;
import com.javatechie.respository.UserRepository;
import com.javatechie.respository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("userName = " + userName);
        Optional<Users> user = userRepository.findById(1L);
        System.out.println("user.get().getUserName() = " + user.get().getName());
        System.out.println("user.get().getUserName() = " + user.get().getEmail());
        System.out.println("user.get().getUserName() = " + user.get().getLocation());
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(TrailDetails::new).get();
    }
}
