package com.ayi.curso.rest.serv.ayispringrestful.utils;

import com.ayi.curso.rest.serv.ayispringrestful.entity.Lendings;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Cod Usuario", "Cod Libro", "Fecha prestamo", "Fecha devolución" };
    static String SHEET = "Prestamos";

    public static ByteArrayInputStream tutorialsToExcel(List<Lendings> lendings) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (Lendings data : lendings) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(data.getUsers().getId());
                row.createCell(1).setCellValue(data.getBooks().getId());
                row.createCell(2).setCellValue(data.getDate_out());
                row.createCell(3).setCellValue(data.getDate_return());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}
