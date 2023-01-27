package com.pranay.hosttry.repositories;


import com.pranay.hosttry.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Students, String> {

}
