package com.anderfolg.exceltesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteExcel {

    XSSFWorkbook workbook = new XSSFWorkbook();

    XSSFSheet sheet = workbook.createSheet("Primitive datatypes in Java");

    Map<String, Object[]> data = new TreeMap<String, Object[]>();

    public void writeExcel() {
        data.put("1", new Object[]{"ID", "TYPE", "DESCRIPTION"});
        data.put("2", new Object[]{1, "boolean", "returns true or false"});
        data.put("3", new Object[]{2, "char", "returns character"});
        data.put("4", new Object[]{3, "double", "returns decimal"});
        data.put("5", new Object[]{4, "float", "returns decimal"});
        data.put("6", new Object[]{5, "int", "returns integer"});
        data.put("7", new Object[]{6, "long", "returns long"});
        data.put("8", new Object[]{7, "short", "returns short"});

        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset){
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr){
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String){
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer){
                    cell.setCellValue((Integer) obj);
                }
            }
            try {
                FileOutputStream out = new FileOutputStream("javaPrimitives.xlsx");
                workbook.write(out);
                out.close();
                System.out.println("javaPrimitives.xlsx written successfully on disk.");

            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
