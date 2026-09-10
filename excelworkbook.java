import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class excelworkbook {

    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir")
                + "\\src\\main\\resources\\Practical6.xlsx";

        File file = new File(path);

        XSSFWorkbook workbook;
        XSSFSheet sheet;

        if (!file.exists()) {

            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Student_Marks");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Student Name");
            header.createCell(1).setCellValue("Java");
            header.createCell(2).setCellValue("Python");
            header.createCell(3).setCellValue("C++");

            Object[][] data = {
                    {"Student1", 75, 55, 45},
                    {"Student2", 40, 35, 50},
                    {"Student3", 55, 62, 58},
                    {"Student4", 80, 90, 85},
                    {"Student5", 45, 50, 40},
                    {"Student6", 65, 55, 59},
                    {"Student7", 30, 45, 50},
                    {"Student8", 70, 72, 68},
                    {"Student9", 58, 59, 61},
                    {"Student10", 35, 40, 42}
            };

            for (int i = 0; i < data.length; i++) {
                Row row = sheet.createRow(i + 1);

                for (int j = 0; j < data[i].length; j++) {
                    Cell cell = row.createCell(j);

                    if (data[i][j] instanceof String)
                        cell.setCellValue((String) data[i][j]);
                    else
                        cell.setCellValue((Integer) data[i][j]);
                }
            }

            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.close();

        } else {

            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("Student_Marks");
            fis.close();
        }

        int totalStudents = sheet.getLastRowNum();
        int count = 0;

        System.out.println("Students Scoring Above 60 in At Least One Subject\n");

        for (int i = 1; i <= totalStudents; i++) {

            boolean passed = false;

            for (int j = 1; j <= 3; j++) {

                double marks = sheet.getRow(i).getCell(j).getNumericCellValue();

                if (marks > 60) {
                    passed = true;
                    break;
                }
            }

            if (passed) {

                System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
                count++;
            }
        }

        double percentage = (count * 100.0) / totalStudents;

        System.out.println("\nTotal Students : " + totalStudents);
        System.out.println("Students Above 60 : " + count);
        System.out.printf("Percentage : %.2f%%", percentage);

        workbook.close();
    }
}
