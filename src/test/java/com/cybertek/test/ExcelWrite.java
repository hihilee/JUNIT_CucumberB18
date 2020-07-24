package com.cybertek.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWrite {

    public static void main(String[] args) throws Exception {
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFRow row;
        XSSFCell cell;

        String path="src\\sampledata.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);

        //workbook>sheet>row>cell
        //loading excel workbook into class
        workbook=new XSSFWorkbook(fileInputStream);

        //get our sheet
        sheet=workbook.getSheet("employees");

        //Kings row
        row= sheet.getRow(1);

        //Kings cell
        cell=row.getCell(1);

        //storing Adam's name cell if you are freq. using it.
        XSSFCell adamscell=sheet.getRow(2).getCell(0);
        System.out.println("Before: "+adamscell);

        //TODO1: change Adams's name to Madam
        adamscell.setCellValue("Madam");

        //TODO2: change Steven's name to Tom
        for(int rowNum=0; rowNum< sheet.getPhysicalNumberOfRows(); rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Steven")){
                sheet.getRow(rowNum).getCell(0).setCellValue("Tom");
            }

        }

        //TODO3: change Neena's job ID to Developer
        for(int rowNum=0; rowNum< sheet.getPhysicalNumberOfRows(); rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Neena")){
                sheet.getRow(rowNum).getCell(2).setCellValue("Best Developer");
            }

        }

        //create a file output stream to specify which file that we are writing
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

        System.out.println("After: "+adamscell);


    }

}
