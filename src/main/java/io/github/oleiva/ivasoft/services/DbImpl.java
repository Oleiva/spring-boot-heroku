package io.github.oleiva.ivasoft.services;

import io.github.oleiva.ivasoft.FIOConverter;
import io.github.oleiva.ivasoft.entity.MarksEntity;
import io.github.oleiva.ivasoft.entity.StudentEntity;
import io.github.oleiva.ivasoft.pojo.MarksPojo;
import io.github.oleiva.ivasoft.jpa.MarksJpa;
import io.github.oleiva.ivasoft.jpa.StudentJpa;
import io.github.oleiva.ivasoft.pojo.StudentPojo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Ivasoft on 01.10.2017.
 */

@Service
public class DbImpl {

@Autowired private MarksJpa marksJpa;
@Autowired private StudentJpa studentJpa;


    public void saveMarks(ArrayList<MarksPojo> list){
        list.forEach(marks -> {
            FIOConverter fioConverter = new FIOConverter();

            System.out.println(marks.getFio());
            System.out.println(fioConverter.getFIOHAshe(marks.getFio()));

            String hash = DigestUtils.sha256Hex(fioConverter.getFIOHAshe(marks.getFio()));
            System.out.println("hash "+hash);
            if (studentJpa.findByFiohash(hash)!=null) {
               long id =  studentJpa.findByFiohash(hash).getSTUD_ID();
               marksJpa.saveAndFlush(new MarksEntity( id, marks.getSubject(), (int) marks.getMark()));
            }else {
                System.out.println("ERROR : "+"I dont know this student "+marks.getFio());
            }

        });
    }

    public void saveStudent(ArrayList<StudentPojo> list){
        System.out.println("saveStudent "+list.size());
        list.forEach(student -> {

            StudentEntity studentEntity = new StudentEntity(student.getName(),student.getSurname(),student.getPatronymic());

            try {
                studentJpa.save(studentEntity);
            }catch (Exception ex){
                System.out.println("Exeption: "+ex);
            }
        });
        studentJpa.flush();
        System.out.println("Saveng");

    }




}
