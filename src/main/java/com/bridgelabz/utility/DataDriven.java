package com.bridgelabz.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataDriven {
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    int rowNum;

    public DataDriven(String excelPath)
    {
        File file = new File(excelPath);
        try
        {
            FileInputStream fis = new FileInputStream(file);
            this.workbook = new XSSFWorkbook(fis);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public String getData(int sheetNo, int row, int column ){
        this.sheet = this.workbook.getSheetAt(sheetNo);
        Cell cell = this.sheet.getRow(row).getCell(column);
        String data = cell.getStringCellValue();
        return data;
    }

    public int getRowCount(int sheetIndex){
        rowNum = this.workbook.getSheetAt(sheetIndex).getLastRowNum();
        ++rowNum;
        return rowNum;
    }
}
