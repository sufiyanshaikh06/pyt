package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class excelautomation {

    public static void writeData(
            String filePath,
            String fileName,
            String sheetName,
            String[] data
    ) throws IOException {

        File file = new File(filePath + "\\" + fileName);

        XSSFWorkbook workbook;
        XSSFSheet sheet;

        if (!file.exists()) {

            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet(sheetName);

        } else {

            FileInputStream fis = new FileInputStream(file);

            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                sheet = workbook.createSheet(sheetName);
            }

            fis.close();
        }

        int rowNum = sheet.getPhysicalNumberOfRows();

        Row newRow = sheet.createRow(rowNum);

        for (int i = 0; i < data.length; i++) {

            Cell cell = newRow.createCell(i);

            cell.setCellValue(data[i]);
        }

        FileOutputStream fos = new FileOutputStream(file);

        workbook.write(fos);

        fos.close();
        workbook.close();
    }

    public static void main(String[] args) throws IOException {

        String[][] students = {
                {"Student1", "21"},
                {"Student2", "22"},
                {"Student3", "20"},
                {"Student4", "21"},
                {"Student5", "21"},
                {"Student6", "23"},
                {"Student7", "19"},
                {"Student8", "22"},
                {"Student9", "20"},
                {"Student10", "19"}
        };

        String path = System.getProperty("user.dir") + "\\src\\main\\resources";

        for (String[] student : students) {

            writeData(path, "Practical5.xlsx", "Sheet1", student);
        }

        System.out.println("Data Written Successfully");
    }
}
