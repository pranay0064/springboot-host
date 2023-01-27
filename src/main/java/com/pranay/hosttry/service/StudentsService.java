package com.pranay.hosttry.service;




import com.pranay.hosttry.entities.StudentsResponse;

import java.util.List;

public interface StudentsService {
    List<StudentsResponse> getAllStudents();
    StudentsResponse getStudent(String id);
}
