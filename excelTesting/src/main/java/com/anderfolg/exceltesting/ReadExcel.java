package com.anderfolg.exceltesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadExcel {

    Map<Integer, String> db = new HashMap<>();

    public void readExcel(){
        try {
            FileInputStream file = new FileInputStream("javaPrimitives.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case FORMULA:
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;

                    }
                    if ( cell.getCellType() == CellType.NUMERIC ){
                        double id = cell.getNumericCellValue();
                        db.put((int) id, "id");
                    }
                }

                System.out.println("");
            }
            System.out.println(db);
            file.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
