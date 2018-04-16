package io.github.oleiva.ivasoft.services;

import io.github.oleiva.ivasoft.entity.MarksEntity;
import io.github.oleiva.ivasoft.entity.PGroup;
import io.github.oleiva.ivasoft.jpa.GroupJpa;
import io.github.oleiva.ivasoft.jpa.MarksJpa;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

@Service

public class NewProcessing {

    @Autowired
    GroupJpa groupJpa;

    @Autowired
    MarksJpa marksJpa;

    public void doit(){
        System.out.println("doit");

        Workbook wb = new XSSFWorkbook();

        for (PGroup group : groupJpa.findAll()) {
            System.out.println("GroupName  :: " + group.getGroupName());
            Sheet sheet = wb.createSheet(group.getGroupName());


            Set<BigInteger> studentIdex = marksJpa.getStudents((group.getId()));
            Set<BigInteger> studentMarks = marksJpa.getMarks((group.getId()));

            int raw_index = 1;
            int cell_header = 1;

            Row row_ = sheet.createRow(0);
            for (BigInteger studentMark : studentMarks){
                row_.createCell(cell_header).setCellValue(String.valueOf(studentMark));
                cell_header++;
            }


            for (BigInteger stud : studentIdex) {
//                System.out.println("students " + stud);

//                List<MarksEntity> marks = marksJpa.getByStudid(Long.parseLong(stud.toString()));
                Map<Long, Long> marksMap = marksToMap(marksJpa.getByStudid(Long.parseLong(stud.toString())));
                Row row = sheet.createRow(raw_index);


                int cell_index =1;
                for (BigInteger studentMark : studentMarks){

                   Long mar = 0L;
                   try {
                        mar = marksMap.get(studentMark.longValue());
                   }catch (Exception ex ){
                       System.out.println("Alarm");
                   }

                    System.out.println("studentMark "+studentMark+" "+mar);
                    row.createCell(cell_index).setCellValue(mar+"");
                    cell_index++;
                }

                raw_index++;
            }



        }


        try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
            wb.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public Map<Long, Long> marksToMap(List<MarksEntity> marks){
        Map<Long,Long> markMap= new HashMap<>();
        marks.forEach(marksEntity -> {
//            System.out.println("SUBJECTID "+marksEntity.getSUBJECTID());
//            System.out.println("getMARKS"+marksEntity.getMARKS());
            markMap.put(marksEntity.getSUBJECTID(),marksEntity.getMARKS());
        });

        System.out.println(markMap.toString());
        return  markMap;
    }
}
