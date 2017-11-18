//package io.github.oleiva.ivasoft;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//
///**
// * Created by Ivasoft on 18.11.2017.
// */
//public class Exel {
//    public static void main(String[] args) throws IOException {
//        writeXLSFile();
//    }
//    public static void writeXLSFile() throws IOException {
//
//        String excelFileName = "d:/Test.xls";//name of excel file
//
//        String sheetName = "Sheet1";//name of sheet
//
//        HSSFWorkbook wb = new HSSFWorkbook();
//        HSSFSheet sheet = wb.createSheet(sheetName) ;
//
//        //iterating r number of rows
//        for (int r=0;r < 5; r++ )
//        {
//            HSSFRow row = sheet.createRow(r);
//
//            //iterating c number of columns
//            for (int c=0;c < 5; c++ )
//            {
//                HSSFCell cell = row.createCell(c);
//
//                cell.setCellValue("Celзззз "+r+" "+c);
//            }
//        }
//
//        FileOutputStream fileOut = new FileOutputStream(excelFileName);
//
//        //write this workbook to an Outputstream.
//        wb.write(fileOut);
//        fileOut.flush();
//        fileOut.close();
//    }
//}
