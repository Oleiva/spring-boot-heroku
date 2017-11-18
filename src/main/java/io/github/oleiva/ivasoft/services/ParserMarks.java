package io.github.oleiva.ivasoft.services;



import io.github.oleiva.ivasoft.pojo.MarksPojo;
import io.github.oleiva.ivasoft.jpa.StudentJpa;
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

public class ParserMarks {

    @Autowired
    private StudentJpa studentJpa;

//    private static final String FILE_NAME = "data/38.xlsx";

    public static void main(String[] args) {
//        tr_atudents();
    }

    public ArrayList<MarksPojo> transformation(File file) {
        ArrayList<MarksPojo> marks = new ArrayList<>();

        String name= "";
        String subject= "";
        double mark= 0.0;
        String grup= "";

        try {

            FileInputStream excelFile = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(excelFile);


            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            while (sheetIterator.hasNext()) {
                Sheet datatypeSheet = sheetIterator.next();

                Iterator<Row> iterator = datatypeSheet.iterator();
                ArrayList<String> subjectList = new ArrayList<>();
                int row = 0, column = 0;


                while (iterator.hasNext()) {
                    ++row;
                    System.out.println(" ряд");

                    Row currentRow = iterator.next();
                    Iterator<Cell> cellIterator = currentRow.iterator();

                    while (cellIterator.hasNext()) {

                        Cell currentCell = cellIterator.next();
                        ++column;

                        int indexC = currentCell.getColumnIndex();
                        int indexR = currentCell.getRowIndex();

                        if (indexR > 0) {
                            if (currentCell.getCellType() == 0) { // число
                                System.out.println("@@@@@ " + indexR + " " + indexC);
                                System.out.println(currentCell);

                                name = datatypeSheet.getRow(indexR).getCell(0).getStringCellValue();
                                subject = datatypeSheet.getRow(0).getCell(indexC).getStringCellValue();
                                mark = 0.0;
                                grup = "";

                                marks.add(new MarksPojo(name, subject, currentCell.getNumericCellValue(), grup));
                            }

                        } else {
                            subjectList.add("");
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

        marks.forEach(x->{
            System.out.println(x.toString());
        });
        System.out.println("//////");
        System.out.println();

        return marks;
    }
}
