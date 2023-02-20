package com.javatechie.respository;

import com.javatechie.entity.ImageData;
import com.javatechie.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
}
