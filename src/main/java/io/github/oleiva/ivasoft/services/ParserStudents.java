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
//                        StudentEntity studentEntity = new StudentEntity();

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


                            if (datatypeSheet.getRow(0).getCell(indexC).getStringCellValue().contains(pattern)) {
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                            };


                            if (datatypeSheet.getRow(0).getCell(indexC).getStringCellValue().contains(pattFIO)) {
                                if (currCell.getStringCellValue() != null && currCell.getStringCellValue().length() > 5) {
                                    System.out.println(currCell.getStringCellValue());
                                    String sells[] = currCell.getStringCellValue().split("\\ ");
//                                    studentPojos.add(new StudentPojo(sells[0], sells[1], sells[2]));
                                 StudentEntity   studentEntity = new StudentEntity( sells[0],  sells[1],  sells[2]);
//                                    studentJpa.saveAndFlush(studentEntity);
                                    System.out.println("studentEntity :: "+studentEntity.toString());




                                    System.out.println("Adress "+datatypeSheet.getRow(indexR).getCell(5));
                                    System.out.println("TYPE "+datatypeSheet.getRow(indexR).getCell(6));

                                    studentEntity.setAddressOfResidence(String.valueOf(datatypeSheet.getRow(indexR).getCell(5)));
                                    studentEntity.setTypeOfStateOfEmergency(String.valueOf(datatypeSheet.getRow(indexR).getCell(6)));
                                    studentEntity.setPassportNumberBirthBertificate(String.valueOf(datatypeSheet.getRow(indexR).getCell(7)));
                                    studentEntity.setDateOFbirth(String.valueOf(datatypeSheet.getRow(indexR).getCell(8)));
                                    studentEntity.setSex(String.valueOf(datatypeSheet.getRow(indexR).getCell(9)));
//                        studentEntity.setSex(String.valueOf(datatypeSheet.getRow(indexR).getCell(10)));
//                        studentEntity.setSex(String.valueOf(datatypeSheet.getRow(indexR).getCell(11)));
//                                    studentEntity.setPlaceOfBirth(String.valueOf(datatypeSheet.getRow(indexR).getCell(12)));
//                                    studentEntity.setContacts(String.valueOf(datatypeSheet.getRow(indexR).getCell(15)));
//                                    studentEntity.setParents_guardians_Name_and_contact(String.valueOf(datatypeSheet.getRow(indexR).getCell(16)));
//                                    studentEntity.setIPN(String.valueOf(datatypeSheet.getRow(indexR).getCell(17)));
//                        studentEntity.setDock_type_that_reason_of_debris(String.valueOf(datatypeSheet.getRow(indexR).getCell(18)));

//                                    studentEntity.setDocSeriesForEntry(String.valueOf(datatypeSheet.getRow(indexR).getCell(19)));
//                        studentEntity.setDocSeriesForEntry(String.valueOf(datatypeSheet.getRow(indexR).getCell(20)));
//                                    studentEntity.setNumber_of_docs_reason_of_debris(String.valueOf(datatypeSheet.getRow(indexR).getCell(21)));
//                                    studentEntity.setDate_of_doc_that_reason_of_debris(String.valueOf(datatypeSheet.getRow(indexR).getCell(22)));
//                                    studentEntity.setIssued_by(String.valueOf(datatypeSheet.getRow(indexR).getCell(23)));
//                                    studentEntity.setTheAverage_score_is_dock(String.valueOf(datatypeSheet.getRow(indexR).getCell(24)));
//                                    studentEntity.setBallForEntry(String.valueOf(datatypeSheet.getRow(indexR).getCell(25)));

//                                    studentEntity.setInosLanguageStudied(String.valueOf(datatypeSheet.getRow(indexR).getCell(26)));
//                        studentEntity.setInosLanguageStudied(String.valueOf(datatypeSheet.getRow(indexR).getCell(27)));
//                        studentEntity.setInosLanguageStudied(String.valueOf(datatypeSheet.getRow(indexR).getCell(28)));
//                        studentEntity.setInosLanguageStudied(String.valueOf(datatypeSheet.getRow(indexR).getCell(29)));
//                                    studentEntity.setdDYear(String.valueOf(datatypeSheet.getRow(indexR).getCell(30)));

//                                    studentEntity.setStartDateOfStudy(String.valueOf(datatypeSheet.getRow(indexR).getCell(31)));
//                                    studentEntity.setGraduationDate(String.valueOf(datatypeSheet.getRow(indexR).getCell(32)));
//                                    studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(33)));

//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(34)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(35)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(36)));

//                                    studentEntity.setCourse(String.valueOf(datatypeSheet.getRow(indexR).getCell(37)));
//                                    studentEntity.setFormOfStudy(String.valueOf(datatypeSheet.getRow(indexR).getCell(38)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(39)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(40)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(41)));

//                                    studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(42)));

//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(43)));
//                                    studentEntity.setSpecialtyCode(String.valueOf(datatypeSheet.getRow(indexR).getCell(44)));
//                                    studentEntity.setSpecialty(String.valueOf(datatypeSheet.getRow(indexR).getCell(45)));

//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(46)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(47)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(48)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(49)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(50)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(51)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(52)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(53)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(54)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(55)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(56)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(57)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(58)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(59)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(60)));
//                        studentEntity.setStructuralUnit(String.valueOf(datatypeSheet.getRow(indexR).getCell(61)));
//                                    studentEntity.setSoftware(String.valueOf(datatypeSheet.getRow(indexR).getCell(62)));




                                    Studentlist.add(studentEntity);


                                }


                            }


                        }



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

