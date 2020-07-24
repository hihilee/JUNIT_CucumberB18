package com.cybertek.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelRead {

    public static void main(String[] args) throws Exception {
        File file=new File("src\\sampledata.xlsx");
       // System.out.println(file.exists());

        //Load the file into java memory using file input stream
        FileInputStream fileInputStream=new FileInputStream(file);

        //Load the excel workbook into the java class
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);

        //workbook->sheet->row->cell

        //getting the sheet from the workbook
        XSSFSheet sheet=workbook.getSheet("employees"); //tab name that in the excel
        //How to get the Sandler from the excel sheet?
        //index starts from 0, first to get row then go to cell.

        sheet.getRow(2).getCell(1); //return a cell
        System.out.println(sheet.getRow(2).getCell(1));

        //count only the used(writtten)cells.Starts counting from 1.
        int usedRows=sheet.getPhysicalNumberOfRows();

        //will count top to bottom,doesnt care if empty cell or used cell
        //starts from 0.
        int lastUsedRow = sheet.getLastRowNum();

        //TODO1-Create a logic that prints out Neena's name dynamically
        //because cell[0] is for the names.
        for(int rowNum=0; rowNum<usedRows; rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Neena")){
                System.out.println("Neena's name is: "+sheet.getRow(rowNum).getCell(0));
            }
        }

        //TODO2-Create a logic that prints out Adams last name dynamically
        for(int rowNum=0; rowNum<usedRows; rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Adam")){
                System.out.println("Adam's Last name is: "+sheet.getRow(rowNum).getCell(1));
            }
        }

        //TODO3-Create a logic that prints out Steve's job dynamically
        for(int rowNum=0; rowNum<usedRows; rowNum++){
            if(sheet.getRow(rowNum).getCell(1).toString().equals("King")){
                System.out.println("King's job is: "+sheet.getRow(rowNum).getCell(2));
            }
        }













    }

}
