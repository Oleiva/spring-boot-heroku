package io.github.oleiva.ivasoft.services;

import io.github.oleiva.ivasoft.ApachePOIExcelRead;
import io.github.oleiva.ivasoft.Student;
import io.github.oleiva.ivasoft.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Ivasoft on 15.11.2017.
 */

@Service
public class ResolverService {
    	private final UserServiceImpl userService;

    @Autowired
    public ResolverService(UserServiceImpl userService) {
        this.userService = userService;
    }
//


    public void resolve(String path, String filename){
        System.out.println("resolve");
        System.out.println(path +filename);

        if (filename.contains("session")){
            System.out.println("Session");

            ApachePOIExcelRead poiExcelRead = new ApachePOIExcelRead();
            ArrayList<Student> list = poiExcelRead.transformation(new File(path +filename));
			userService.setStudent(list);

        }else {
            System.out.println("EMPTY");
        }



    }

}
