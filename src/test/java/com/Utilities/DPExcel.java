package com.Utilities;

import org.testng.annotations.DataProvider;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DPExcel {

    @DataProvider(name = "excelData", parallel = true)
    public Object[][] excelDataprovider() {
        String fileName = "testdata.xlsx";
        String sheetName = "Sheet1";
        Object[][] data = getExceldata(fileName, sheetName);
        if (data == null || data.length == 0) {
            throw new RuntimeException("Excel data is empty or file not found!");
        }
        return data;
    }

    public String[][] getExceldata(String fileName, String sheetName) {
        String[][] data = null;
        try (
            InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(is)
        ) {
            if (is == null) {
                throw new RuntimeException("Excel file Not found in resources folder");
            }
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = sheet.getRow(0).getLastCellNum();
            data = new String[noOfRows - 1][noOfCols];
            DataFormatter formatter = new DataFormatter();
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    Cell cell = sheet.getRow(i).getCell(j);
                    data[i - 1][j] = formatter.formatCellValue(cell);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception while reading Excel: " + e.getMessage());
        }
        return data;
    }
}
