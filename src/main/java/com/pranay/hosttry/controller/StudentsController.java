package com.pranay.hosttry.controller;


import com.pranay.hosttry.entities.StudentsResponse;
import com.pranay.hosttry.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/students", produces = "application/json")
public class StudentsController {

    private final StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping
    public List<StudentsResponse> getAllStudents(){
        return studentsService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentsResponse getStudentBasedOnId(@PathVariable String id){
        return studentsService.getStudent(id);
    }
}
