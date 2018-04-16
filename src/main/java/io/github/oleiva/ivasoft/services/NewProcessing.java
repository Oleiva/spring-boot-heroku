package io.github.oleiva.ivasoft.services;

import io.github.oleiva.ivasoft.entity.MarksEntity;
import io.github.oleiva.ivasoft.entity.PGroup;
import io.github.oleiva.ivasoft.jpa.GroupJpa;
import io.github.oleiva.ivasoft.jpa.MarksJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

@Service

public class NewProcessing {

    @Autowired
    GroupJpa groupJpa;

    @Autowired
    MarksJpa marksJpa;

    public void doit(){
        System.out.println("doit");

        groupJpa.findAll().forEach(group ->{
            System.out.println("GroupName  :: "+group.getGroupName());

            Set<BigInteger> studentIdex = marksJpa.getStudents((group.getId()));

            studentIdex.forEach(x->{
                System.out.println("students "+x);

                marksJpa.getByStudid(Long.parseLong(x.toString())).forEach(y->{
                    System.out.println("marks :: "+y);
                });




            });



//            marksJpa.findByGroupid((group.getId())).forEach(marks -> {
////                System.out.println("?marks "+marks.toString());
//
//             Set<String> studentIdex =   marks.getSTUD_ID();
//
//            });

        });





    }
}
