package io.github.oleiva.ivasoft.services;


import io.github.oleiva.ivasoft.entity.MarksEntity;
import io.github.oleiva.ivasoft.entity.StudentEntity;
import io.github.oleiva.ivasoft.jpa.MarksJpa;
import io.github.oleiva.ivasoft.pojo.MarksPojo;
import io.github.oleiva.ivasoft.pojo.StudentPojo;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivasoft on 15.11.2017.
 */

@Service
public class ResolverService {

@Autowired
private MarksJpa marksJpa;
    	private final DbImpl database;
    	private final ExelExport exelExport;

    @Autowired
    public ResolverService(DbImpl database, ExelExport exelExport) {
        this.database = database;
        this.exelExport = exelExport;
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




    public void processing(){
        exelExport.processing();
    }


    public void processing2(){
/**
 *
 * Взяь всех студентов
 * Взять список предметов
 *
 * Для каждого студента выборка оценок.
 *
 * Маппинг по оценкам.
 *
 *
 */


        List<StudentEntity> students = database.getAllStudents();
        List<String> subject = new ArrayList<>();
            subject.add("Експлоатація ЕСіМ");
            subject.add("Системи електропосточання");
            subject.add("Системи edfededer");
            subject.add("wdewdw43 edfededer");

//
        String excelFileName = "d:/Test.xls";//name of excel file
        String sheetName = "Sheet1";//name of sheet

        students.forEach((StudentEntity stu) ->{
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet(sheetName) ;

//        Шапка
                HSSFRow rowі = sheet.createRow(0);
                //iterating c number of columns

            int index =1;
                for (int c=0;c < subject.size(); c++ ) {
                    HSSFCell cell = rowі.createCell(index);
                    cell.setCellValue(subject.get(c));
                    index++;
                }
            //iterating r number of rows
            for (int r=1;r < students.size()+1; r++ ) {
                HSSFRow row = sheet.createRow(r);
                StudentEntity studentEntity = students.get(r-1);

                //iterating c number of columns
                for (int c=0;c < subject.size(); c++ ) {
                    HSSFCell cell = row.createCell(c);
                    if (c ==0){
                        cell.setCellValue(studentEntity.getSurname()+" " +studentEntity.getName());
                    }else{
                        long studId = studentEntity.getSTUD_ID();
                        System.out.println("studId "+studId);

                        long id =0;
                        try {
                            MarksEntity marksEntity = marksJpa.getMarksEntitiesBySTUD_ID(studId);
                            System.out.println("marksEntity.getSUBJECTID();"+marksEntity.getSUBJECTID());
                        }catch (Exception e){

                        }


                        System.out.println("");


                        cell.setCellValue("Cell "+r+" "+c);
                    }

                }
            }

//            //iterating r number of rows
//            for (int r=1;r < students.size()+1; r++ ) {
//                HSSFRow row = sheet.createRow(r);
//                StudentEntity studentEntity = students.get(r-1);
//
//                //iterating c number of columns
////                for (int c=0;c < subject.size()+1; c++ ) {
////                    HSSFCell cell = row.createCell(c);
////                    System.out.println("Celзззз "+r+1+" "+c+1);
////
////                    if (c ==0){
////                        cell.setCellValue(studentEntity.getSurname()+" " +studentEntity.getName());
////                    }else {
////                        cell.setCellValue("");
////                    }
////
////
////                }
//            }

            FileOutputStream fileOut = null;
            try {
                fileOut = new FileOutputStream(excelFileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            //write this workbook to an Outputstream.
            try {
                wb.write(fileOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOut.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        });







    }




}
