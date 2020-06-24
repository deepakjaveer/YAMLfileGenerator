package org.chandra.apps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileConverter {
    public static final String filepath="F:\\WorkSpace\\YAMLfileGenerator\\src\\main\\resources\\test.xlsx";

   static HashMap<String,String>details = new HashMap<>();
   public static String cellval="";
    public static void main(String[] args) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File(filepath));
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        System.out.println("Retrieving Sheets using Iterator");
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            System.out.println("=> " + sheet.getSheetName());
        }
        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter dataFormatter = new DataFormatter();



        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();


            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String  cellValue = dataFormatter.formatCellValue(cell);

               System.out.println("Cell value is :"+cell.getStringCellValue());
                System.out.print(cellValue +"\t");

                workbook.close();
                ObjectMapper om = new ObjectMapper(new YAMLFactory());
                om.writeValue(new File("F:\\WorkSpace\\YAMLfileGenerator\\src\\main\\resources\\descriptor.yaml"),cell.getStringCellValue());
            }


            //  details.put(row,"");


            System.out.println();
          /*  for (int i=0;i<entry.size();i++){
                System.out.println("Value in Arraylist is :"+entry.get(i));
            }*/


        }
    }




}
