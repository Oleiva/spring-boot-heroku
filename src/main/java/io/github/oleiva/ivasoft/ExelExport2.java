package io.github.oleiva.ivasoft;

//https://poi.apache.org/spreadsheet/quick-guide.html
//org.apache.poi ver. 3.11

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExelExport2 {


public  static void exel(){

    Workbook wb = new XSSFWorkbook();



    Sheet sheet = wb.createSheet("new sheet2");


    Row row = sheet.createRow(1);


    row.createCell(0).setCellValue(1.2);




    try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
        wb.write(fileOut);
    } catch (IOException e) {
        e.printStackTrace();
    }


}
    public static void main(String[] args) throws IOException {
        ExelExport2 exelExport = new ExelExport2();
        exelExport.exel();
    }
}
