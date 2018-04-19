package io.github.oleiva.ivasoft.services;

import io.github.oleiva.ivasoft.entity.StudentEntity;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivasoft on 19.11.2017.
 */

@Service
public class ExelExport {
    private final DbImpl database;

    public ExelExport(DbImpl database) {
        this.database = database;
    }

    public void processing() {
        List<StudentEntity> students = database.getAllStudents();
        JSONArray studentsArray = new JSONArray();

        students.forEach(studentEntity -> {
            JSONObject student = new JSONObject();

            student.put("name", studentEntity.getName());
            student.put("surname", studentEntity.getSurname());
            student.put("marks",  getMarksList());
            studentsArray.add(student);
        });

        exelExport(studentsArray);
    }

    public JSONObject getMarksList(){
        ArrayList<String> markList = new ArrayList<>();
        markList.add("java");
        markList.add("scala");
        markList.add("python");

       JSONObject  marks = new JSONObject();
        markList.forEach(lis->{
            marks.put(lis,90);
        });


        return marks;
    }


    public static void exelExport(JSONArray studentsArray) {
        String excelFileName = "d:/Test.xls";//name of excel file
        String sheetName = "Sheet1";//name of sheet

        ArrayList<String> markList = new ArrayList<>();
        markList.add("java");
        markList.add("C@");
        markList.add("python");
        markList.add("scala");

        System.out.println(studentsArray);
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);

        HSSFRow row_0 = sheet.createRow(0);
        //iterating c number of columns

        for (int c = 0; c < markList.size(); c++) {
            HSSFCell cell = row_0.createCell(c + 1);
            cell.setCellValue(markList.get(c));
        }


        for (int x = 0; x < studentsArray.size(); x++) {
            HSSFRow rowі = sheet.createRow(x + 1);

            for (int col = 0; col < markList.size(); col++) {
                Object json = studentsArray.get(x);

                JSONObject jsonObject = (JSONObject) json;
                String name = (String) jsonObject.get("name");

                Object marks1 = jsonObject.get("marks");
                JSONObject jsonObjectww = (JSONObject) marks1;
                Object ff = null;

                try {
                    ff = jsonObjectww.get(markList.get(col));
                } catch (Exception e) {

                }

                if (col == 0) {
                    HSSFCell cell = rowі.createCell(0);
                    cell.setCellValue(name);
                }


                System.out.println(name + " " + col + " " + ff);
                HSSFCell cell = rowі.createCell(col + 1);
                String tur = "";
                try {
                    tur = ff.toString();
                } catch (Exception e) {

                }

                cell.setCellValue(" " + tur);

            }
        }


        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(excelFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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


    }
}
