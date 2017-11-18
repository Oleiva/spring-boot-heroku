package io.github.oleiva.ivasoft.services;

import io.github.oleiva.ivasoft.pojo.MarksPojo;
import io.github.oleiva.ivasoft.pojo.StudentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Ivasoft on 15.11.2017.
 */

@Service
public class ResolverService {


    	private final DbImpl database;

    @Autowired
    public ResolverService(DbImpl database) {
        this.database = database;
    }
//


    public void resolve(String path, String filename){
        System.out.println("resolve");
        System.out.println(path +filename);

        if (filename.contains("session")){ // MarksPojo
            System.out.println("Session");

            ParserMarks poiExcelRead = new ParserMarks();
            ArrayList<MarksPojo> list = poiExcelRead.transformation(new File(path +filename));
			database.saveMarks(list);

        }
        else if (filename.contains("students")){// Students
            ParserStudents poiExcelRead = new ParserStudents();
            ArrayList<StudentPojo> list = poiExcelRead.tr_atudents(new File(path +filename));
            database.saveStudent(list);
        }
        else {
            System.out.println("EMPTY");
        }



    }

}
