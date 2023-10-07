package com.company.utils;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelConfig {

    private XSSFWorkbook wb;
    private XSSFSheet sh;
    private FileInputStream fileIn;

    public ExcelConfig(String excelPath) {
        try {
            File file = new File(excelPath);
            fileIn = new FileInputStream(file);
            wb = new XSSFWorkbook(fileIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public ExcelConfig() {
        try {
            File file = new File("");
            fileIn = new FileInputStream(file);
            wb = new XSSFWorkbook(fileIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNumRow() {
        sh = wb.getSheet("Test data");
        return sh.getLastRowNum();
    }

    public int getColNum() {
        sh = wb.getSheet("Test data");
        return sh.getRow(0).getLastCellNum();
    }

    public String getDataValue(int rowNum, int colNum) {
        sh = wb.getSheet("Test data");
        DataFormatter df = new DataFormatter();
        try {
            return df.formatCellValue(sh.getRow(rowNum).getCell(colNum));
        } catch (NullPointerException npe) {
            return "";
        }
    }

    public Object[][] data() {
        int rowNum = getNumRow();
        int colNum = getColNum();
        System.out.println("Row num: " + rowNum);
        System.out.println("Col num: " + colNum);
        Object[][] obj = new Object[rowNum][colNum];
        int currentRow = 0;
        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                obj[currentRow][j] = getDataValue(i, j);
            }
            currentRow++;
        }
        return obj;
    }


}