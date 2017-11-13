package io.github.oleiva.ivasoft;

import io.github.oleiva.ivasoft.entity.MarksEntity;
import io.github.oleiva.ivasoft.entity.StudentEntity;
import io.github.oleiva.ivasoft.jpa.MarksJpa;
import io.github.oleiva.ivasoft.jpa.StudentJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Ivasoft on 01.10.2017.
 */

@Service
public class UserServiceImpl {

@Autowired private MarksJpa marksJpa;
@Autowired private StudentJpa studentJpa;


    public void setStudent(ArrayList<Student> list){
        list.forEach(student -> {

            System.out.println(student.getName());

            if(studentJpa.findByStudname(student.getName())==null){
                studentJpa.saveAndFlush(new StudentEntity(student.getName()));
                System.out.println("1");
            }else {
                System.out.println("2");
            }
            long id = studentJpa.findByStudname(student.getName()).getSTUD_ID();

            marksJpa.saveAndFlush(new MarksEntity( id, student.getSubject(), (int) student.getMark()));
        });

    }


}
