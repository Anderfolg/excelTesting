package com.anderfolg.exceltesting;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageExcel {
    public void addImage() throws IOException {
        Workbook wb = new XSSFWorkbook();

        InputStream is = new FileInputStream("src/main/resources/sus.jpg");
        byte[] bytes = IOUtils.toByteArray(is);
        int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
        is.close();

        CreationHelper helper = wb.getCreationHelper();


        Sheet sheet = wb.createSheet();


        Drawing drawing = sheet.createDrawingPatriarch();


        ClientAnchor anchor = helper.createClientAnchor();

        anchor.setCol1(0);
        anchor.setRow1(0);
        Picture pict = drawing.createPicture(anchor, pictureIdx);

        pict.resize();


        String file = "src/main/resources/sus.jpg";
        if(wb instanceof XSSFWorkbook) file += "x";
        FileOutputStream fileOut = new FileOutputStream(file);
        wb.write(fileOut);
        fileOut.close();
    }
}
