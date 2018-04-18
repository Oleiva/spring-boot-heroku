package io.github.oleiva.ivasoft.services;


import io.github.oleiva.ivasoft.entity.StudentEntity;
import io.github.oleiva.ivasoft.jpa.StudentJpa;
//import io.github.oleiva.ivasoft.pojo.MarksPojo;
import io.github.oleiva.ivasoft.pojo.StudentPojo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParserStudents {

//    @Autowired
//    private StudentJpa studentJpa;

//    private static final String FILE_NAME = "db/students.xlsx";
//
//    public static void main(String[] args) {
//        tr_atudents(new File(FILE_NAME));
//    }

    @Autowired StudentJpa studentJpa;

    public List<StudentEntity> tr_atudents(File file) {
        ArrayList<StudentEntity>  Studentlist=new ArrayList<>();

//        ArrayList<StudentPojo> students = new ArrayList<>();
        String name= "";
        String subject= "";
        double mark= 0.0;
        String grup= "";

//        ArrayList<StudentPojo> studentPojos =new ArrayList<>();

        try {
            FileInputStream excelFile = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(excelFile);

            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            while (sheetIterator.hasNext()) {
                Sheet datatypeSheet = sheetIterator.next();

                Iterator<Row> rowIterator = datatypeSheet.iterator();
                ArrayList<String> subjectList = new ArrayList<>();
                int row = 0, column = 0;


                while (rowIterator.hasNext()) {
                    ++row;
                    System.out.println(" ряд");

                    Row currentRow = rowIterator.next();
                    System.out.println(currentRow);
                    Iterator<Cell> cellIterator = currentRow.iterator();

                    while (cellIterator.hasNext()) {

                        Cell currentCell = cellIterator.next();
                        ++column;

                        int indexR = currentCell.getRowIndex();
                        int indexC = currentCell.getColumnIndex();
                        System.out.println("index ::  "+indexR+" "+indexC+" "+datatypeSheet.getRow(indexR).getCell(indexC));

                       String pattern = "№ п/п";
                       String pattFIO = "ПІБ студента";
                       Cell currCell = datatypeSheet.getRow(indexR).getCell(indexC);
//
                        if (indexR>0) {
                            StudentEntity studentEntity = new StudentEntity();

                            if (datatypeSheet.getRow(0).getCell(indexC).getStringCellValue().contains(pattern)) {
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                            };


                            if (datatypeSheet.getRow(0).getCell(indexC).getStringCellValue().contains(pattFIO)) {
                                if (currCell.getStringCellValue() != null && currCell.getStringCellValue().length() > 5) {
                                    System.out.println(currCell.getStringCellValue());
                                    String sells[] = currCell.getStringCellValue().split("\\ ");
//                                    studentPojos.add(new StudentPojo(sells[0], sells[1], sells[2]));
                                    studentEntity = new StudentEntity( sells[0],  sells[1],  sells[2]);
//                                    studentJpa.saveAndFlush(studentEntity);
                                    System.out.println("studentEntity :: "+studentEntity.toString());
//                                    studentJpa.saveAndFlush(studentEntity);
                                    Studentlist.add(studentEntity);
                                }


                            }
                            ;

                        }



//                        System.out.println(currentCell);

//                        if (indexR > 0) {
////                            if (currentCell.getCellType() == 0) { // число
////                                System.out.println("@@@@@ " + indexR + " " + indexC);
////                                System.out.println(currentCell);
////                                System.out.println("TTTT");
////
////                                name = datatypeSheet.getRow(indexR).getCell(0).getStringCellValue();
////                                subject = datatypeSheet.getRow(0).getCell(indexC).getStringCellValue();
////                                mark = 0.0;
////                                grup = "";
////
////                                students.add(new StudentPojo(name, subject, currentCell.getNumericCellValue(), grup));
////                            }
//
//                        } else {
//                            subjectList.add("");
//                        }


                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException ");
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }

//        students.forEach(x->{
//            System.out.println(x.toString());
//        });
        System.out.println("//////");
        System.out.println();

//        studentPojos.forEach(user->{
//            System.out.println(user.toString());
//        });


        return Studentlist;
    }

//    private static class StudentPojo{
//        String name;
//        String surname;
//        String patronymic;
//
//        public StudentPojo(){}
//
//        public StudentPojo(String name, String surname, String patronymic) {
//            this.name = name;
//            this.surname = surname;
//            this.patronymic = patronymic;
//        }
//
//        @Override
//        public String toString() {
//            return "StudentPojo{" +
//                    "name='" + name + '\'' +
//                    ", surname='" + surname + '\'' +
//                    ", patronymic='" + patronymic + '\'' +
//                    '}';
//        }
//    }
}

