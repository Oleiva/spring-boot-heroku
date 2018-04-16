package io.github.oleiva.ivasoft;


//org.apache.poi ver. 3.11

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExelExport {

    public static void exel() throws IOException {

        int rownum;

        FileOutputStream out = new FileOutputStream("ompanyDB.xls");

        Workbook wb = new HSSFWorkbook();    // create a new workbook
        Sheet s = wb.createSheet();            // create a new sheet
        Row r = null;                        // declare a row object reference
        Cell c = null;                        // declare a cell object reference

        // Create 3 cell styles

        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();
        CellStyle cs3 = wb.createCellStyle();
        CellStyle cs4 = wb.createCellStyle();
        CellStyle cs5 = wb.createCellStyle();

        DataFormat df = wb.createDataFormat();

        Font f = wb.createFont();    // create  fonts object
        Font f2 = wb.createFont();    // create  fonts object

        f.setFontHeightInPoints((short) 12);    //set font 1 to 12 point type
        f.setColor((short) 0xFF8000);            //make it blue
        f.setBoldweight(Font.COLOR_NORMAL);    //make it bold//arial is the default font

        f2.setFontHeightInPoints((short) 9);    //set font 2 to 10 point type
        f2.setColor((short) Font.COLOR_RED);   //make it red
        f2.setBoldweight(Font.BOLDWEIGHT_BOLD); //make it bold
        f2.setStrikeout(true);

// ����� ���������

        cs.setFont(f);//set cell stlye
        cs.setDataFormat(df.getFormat("#,##0"));//set the cell format
        cs.setBorderBottom(cs.BORDER_THICK);
        cs.setAlignment(cs.ALIGN_CENTER);
        cs.setBorderTop(cs.VERTICAL_BOTTOM);
        cs.setBorderLeft((short) 2);
        cs.setLeftBorderColor((short) 10);
        cs.setBottomBorderColor((short) 10);
        cs.setDataFormat((short) 1);
        cs.setFillPattern((short) CellStyle.SOLID_FOREGROUND);
        cs.setFillForegroundColor((short) 50);//49


// ����� ��������� ������

        cs2.setFont(f2);// set the font
        cs2.setBorderBottom(cs.VERTICAL_BOTTOM);
        cs2.setBorderBottom(cs.VERTICAL_JUSTIFY);
        cs2.setBorderBottom(cs.VERTICAL_TOP);
        cs2.setBorderLeft((short) 8); // ����� �� �������.
        cs2.setBottomBorderColor((short) 10);
        cs2.setFillPattern((short) CellStyle.SOLID_FOREGROUND);
        cs2.setFillForegroundColor((short) 4); // ���� ������// 1-��� 2-���� 3-����� 4-��� 5-���� 51-����� 451-���������  46 ����
        wb.setSheetName(0, "Ivasoft (��)");        // in case of plain ascii

// <������ ������ (�����)>

        r = s.createRow(0);
        int i;
        String k[] = {"�����", "# �����", "��������", "��������", "��� ����", "�������", "���-����",};

        for (i = 0; i < 7; i++) {

            c = r.createCell(i);
            c.setCellStyle(cs);
            c.setCellValue(k[i]);
            r.setHeight((short) 0x249);
            s.setColumnWidth((short) 1, 20);

        }

        // </������ ������ (�����)>
        int dataParser = 100;

//        for (rownum = 1; rownum < dataParser.length; rownum++){// <create a sheet with rows> // ����
//
//            if (Parser.DataConsNum[rownum] == 0){// <if >
//                break;
//            }
//            r = s.createRow(rownum); // create a row
//
//            c = r.createCell(0);
//            c.setCellValue(rownum);
//
//            c = r.createCell(1);
//            c.setCellValue(Parser.DataConsNum[rownum]);
//            s.setColumnWidth((short) (rownum + 1), (short) ((50 * 8) / ((double) 1 / 20)));
//
//            c = r.createCell(2);
//            c.setCellValue(Parser.DataMasthead[rownum]);
//
//            c = r.createCell(3);
//            c.setCellValue(Parser.DataDescription[rownum]);
//
//            c = r.createCell(4);
//            c.setCellValue(Parser.DataContaktFace[rownum]);
//
//            c = r.createCell(5);
//            c.setCellValue(Parser.DataTelephoneGood[rownum]);
//
//            c = r.createCell(6);
//            c.setCellValue(Parser.DataWebsite[rownum]);
//
//
//        }// </create a sheet with rows>

        wb.write(out);
        out.close();

        System.out.println("OK");
    }

    public static void main(String[] args) throws IOException {
        ExelExport exelExport = new ExelExport();
        exelExport.exel();
    }
}
