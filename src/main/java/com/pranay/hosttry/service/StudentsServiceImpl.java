package com.pranay.hosttry.service;


import com.pranay.hosttry.entities.Students;
import com.pranay.hosttry.entities.StudentsResponse;
import com.pranay.hosttry.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentsServiceImpl implements StudentsService{

    private StudentsRepository studentsRepository;

    @Autowired
    public StudentsServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<StudentsResponse> getAllStudents() {
        List<Students> studentsResponseList=studentsRepository.findAll();
        List<StudentsResponse> studentsResponses=new ArrayList<>();
        for(int i=0;i<studentsResponseList.size();i++){
            Students students=studentsResponseList.get(i);
            StudentsResponse studentsResponse=new StudentsResponse();
            studentsResponse.setId(students.getId());
            studentsResponse.setName(students.getName());
            studentsResponse.setSchool(students.getSchool());
            studentsResponses.add(studentsResponse);
        }
        return studentsResponses;
    }

    /**
     * Compare call
     *  1.Settings
     *  2. Notification
     *  3. Custom Objects
     *   -> Return compare Id
     *   -> Store in the DB and make them as INPROGRESS
     *   -> Settings call will complete -> update the status to DONE
     *
     *   UI  -> compare/101/settings
     *      -> compare/101/notifications
     *      -> go check the db -> if it is inprogress
     *      -> return as inprogress -> UI they have to poll untill it is DONE
     *      -> else return
     *          -> result will be saved in DB
     *          -> return the result
     *
     * @param id
     * @return
     */
    @Override
    public StudentsResponse getStudent(String id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after sleeping");
        Optional<Students> optionalStudent=studentsRepository.findById(id);
        String name=optionalStudent.get().getName();
        System.out.println("before while name "+name);
        while(name!="mintu"){
            System.out.println("inside while");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("inside while after sleep");
            Optional<Students> optionalStudent1=studentsRepository.findById(id);
            System.out.println("inside while after db call name "+optionalStudent1.get().getName());
            name=optionalStudent1.get().getName();
            System.out.println("inside while after name change "+name);
        }
        StudentsResponse studentsResponse=new StudentsResponse();
        studentsResponse.setId(id);
        studentsResponse.setName(optionalStudent.get().getName());
        studentsResponse.setSchool(optionalStudent.get().getName());
        //5 sec--thread.sleep
        //5-25 db then return data[]
//        if(status==pending){
//            wait();
//
//        }
        //25 return []
        return studentsResponse;
    }
}
