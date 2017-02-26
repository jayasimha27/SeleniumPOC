/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class ApachePOIXLSReader {

    public static Object[][] excelRead(String filePath) throws Exception {
        File excel = new File(filePath);
        FileInputStream fis = new FileInputStream(excel);

        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet ws = wb.getSheet("Sheet1");

        int rowNum = ws.getLastRowNum() + 1;
        int colNum = ws.getRow(0).getLastCellNum();
        Object[][] data = new Object[(rowNum - 1)][colNum];

        int k = 0;
        for (int i = 1; i < rowNum; i++) {
            HSSFRow row = ws.getRow(i);
            for (int j = 0; j < colNum; j++) {
                HSSFCell cell = row.getCell(j);
                Object value = cellToObject(cell);
                data[k][j] = value;
            }
            k++;
        }
        return data;
    }

    
    private static Object cellToObject(HSSFCell cell) {
        Object result;
        switch (cell.getCellType()) {

            case Cell.CELL_TYPE_NUMERIC:
                result = cell.getNumericCellValue();
                break;

            case Cell.CELL_TYPE_STRING:
                result = cell.getStringCellValue();
                break;

            case Cell.CELL_TYPE_BOOLEAN:
                result = cell.getBooleanCellValue();
                break;

            case Cell.CELL_TYPE_FORMULA:
                result = cell.getCellFormula();
                break;

            default:
                throw new RuntimeException("Unknown Cell Type");
        }

        return result;

    }

}
