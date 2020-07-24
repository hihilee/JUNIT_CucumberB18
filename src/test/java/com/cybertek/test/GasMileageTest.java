package com.cybertek.test;

import com.cybertek.pages.GasMileageCalculatorPage;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

public class GasMileageTest {
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    GasMileageCalculatorPage gasMileageCalculatorPage=new GasMileageCalculatorPage();

    @Test
    public void gasMileageCalculatorTest() throws Exception{
        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");

        String path="src\\test\\resources\\testdata\\GasMileageTestData.xlsx";
        //loading the workbook to class
        FileInputStream fileInputStream=new FileInputStream(path);
        workbook=new XSSFWorkbook(fileInputStream);
        sheet=workbook.getSheet("Sheet1");
        XSSFRow currentRow=sheet.getRow(1);


        //double current=123000;
        double current=currentRow.getCell(2).getNumericCellValue();
        gasMileageCalculatorPage.currentOdometerReading.clear();
        gasMileageCalculatorPage.currentOdometerReading.sendKeys(String.valueOf(current));

        //double previous=122000;
        double previous=currentRow.getCell(3).getNumericCellValue();
        gasMileageCalculatorPage.previousOdometerReading.clear();
        gasMileageCalculatorPage.previousOdometerReading.sendKeys(String.valueOf(previous));

        double gas=70;
        gasMileageCalculatorPage.gasAmount.clear();
        gasMileageCalculatorPage.gasAmount.sendKeys(String.valueOf(gas));

        gasMileageCalculatorPage.calculateButton.click();

        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        double expectedResult=(current-previous)/gas;
        System.out.println(decimalFormat.format(expectedResult));

        String [] actualResult=gasMileageCalculatorPage.result.getText().split(" ");
        System.out.println(actualResult[0]);

        //create the cell if it is empty

        if(currentRow.getCell(4)==null){
            currentRow.createCell(4);
        }

        //sending the expected value from our formula
        currentRow.getCell(4).setCellValue(expectedResult);

        if(currentRow.getCell(5)==null){
            currentRow.createCell(5);
        }

        //sending the expected value from our formula
        currentRow.getCell(4).setCellValue(actualResult[0]);


        fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();








    }
}
