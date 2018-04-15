package io.github.oleiva.ivasoft.services;

import io.github.oleiva.ivasoft.FIOConverter;
import io.github.oleiva.ivasoft.entity.MarksEntity;
import io.github.oleiva.ivasoft.entity.PGroup;
import io.github.oleiva.ivasoft.entity.StudentEntity;
import io.github.oleiva.ivasoft.entity.SubjectEntity;
//import io.github.oleiva.ivasoft.jpa.GroupJpa;
import io.github.oleiva.ivasoft.jpa.GroupJpa;
import io.github.oleiva.ivasoft.jpa.SubjectJpa;
import io.github.oleiva.ivasoft.pojo.MarksPojo;
import io.github.oleiva.ivasoft.jpa.MarksJpa;
import io.github.oleiva.ivasoft.jpa.StudentJpa;
import io.github.oleiva.ivasoft.pojo.StudentPojo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivasoft on 01.10.2017.
 */

@Service
public class DbImpl {

@Autowired private MarksJpa marksJpa;
@Autowired private StudentJpa studentJpa;
@Autowired private SubjectJpa subjectJpa;
@Autowired private GroupJpa groupJpa;



    public void saveMarks(ArrayList<MarksPojo> list){
        list.forEach(marks -> {
            FIOConverter fioConverter = new FIOConverter();

            System.out.println(marks.getFio());
            System.out.println(fioConverter.getFIOHAshe(marks.getFio()));

            String hash = DigestUtils.sha256Hex(fioConverter.getFIOHAshe(marks.getFio()));
            System.out.println("hash "+hash);
            if (studentJpa.findByFiohash(hash)!=null) {
               long id =  studentJpa.findByFiohash(hash).getSTUD_ID();

               String subject = marks.getSubject();
               long subjId =0;
                try {
                    subjId =  subjectJpa.findBySubject(subject).getID();
                }catch (Exception ex){
                    System.out.println(ex);
                }
                if (subjId==0){
                    SubjectEntity subjectEntity = new SubjectEntity(subject);
                    subjectJpa.saveAndFlush(subjectEntity);
                    subjId =  subjectJpa.findBySubject(subject).getID();
                }

                String group = marks.getGrup();
                long  group_id;
                if(groupJpa.findByGroupName(group)==null){
                    group_id = groupJpa.save(new PGroup(group)).getId();
                }else{
                    group_id= groupJpa.findByGroupName(group).getId();
                }

                String group_index =marks.getGrup_index();

               marksJpa.saveAndFlush(new MarksEntity( id, subjId, (int) marks.getMark(), group_id,group_index));
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
        System.out.println("Saveng. All OK");

    }

    public List<StudentEntity> getAllStudents(){
     return    studentJpa.findAll();
    }




}
