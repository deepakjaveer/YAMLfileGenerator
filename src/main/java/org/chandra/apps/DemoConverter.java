package org.chandra.apps;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.chandra.apps.model.Topic;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoConverter {
  //  public static final String filepath="F:\\WorkSpace\\YAMLfileGenerator\\src\\main\\resources\\topicmanager.xlsx";

    public static List<Topic>readTopicConfig(String filename){
        List<Topic>topicList = new ArrayList<Topic>();
        try{
            FileInputStream fis = new FileInputStream(filename);
            Workbook workbook = null;
            if(filename.toLowerCase().endsWith(".xlsx")){
                workbook = new XSSFWorkbook(fis);
            }else if (filename.toLowerCase().endsWith(".xls")){
                workbook = new HSSFWorkbook(fis);
            }
            int numberOfSheets = workbook.getNumberOfSheets();
            for(int i=0;i<numberOfSheets;i++){
                Sheet sheet = workbook.getSheetAt(i);
                Iterator<Row>rowIterator = sheet.iterator();
                while (rowIterator.hasNext()){
                     String source="";
                     String market="";
                     String project="";
                     String topicName="";
                     String type="";
                     String datatype="";
                     Double replicationFactor=0.0;
                    Double numPartitions=0.0;

                  Row row = rowIterator.next();
                  Iterator<Cell>cellIterator = row.cellIterator();

                  while (cellIterator.hasNext()){
                      Cell cell = cellIterator.next();
                   //   source = cell.getStringCellValue().trim();

                      market=cell.getStringCellValue().trim();
                      project=cell.getStringCellValue().trim();
                      topicName=cell.getStringCellValue().trim();
                      type=cell.getStringCellValue().trim();
                      datatype=cell.getStringCellValue().trim();
                      source=row.getCell(1).getStringCellValue();
                      System.out.println("value of source :"+source);

                    //  replicationFactor= cell.getNumericCellValue();
                    //  numPartitions= cell.getNumericCellValue();
                     /* switch (cell.getCellType()){
                          case Cell.CELL_TYPE_STRING :
                              if (source.equalsIgnoreCase("")){
                                  System.out.println("Test:"+cell.getStringCellValue().trim());
                                  source = cell.getStringCellValue().trim();
                              }
                              else if (market.equalsIgnoreCase("")){
                                  market= row.getCell(1).getStringCellValue().trim();
                                //  market=cell.getStringCellValue().trim();
                              }
                              else if (project.equalsIgnoreCase("")){
                                  project= row.getCell(2).getStringCellValue().trim();
                                  //project=cell.getStringCellValue().trim();
                              }
                              else if (topicName.equalsIgnoreCase("")){
                                  topicName= row.getCell(3).getStringCellValue().trim();
                                  //topicName=cell.getStringCellValue().trim();
                              }
                              else if (type.equalsIgnoreCase("")){
                                  type= row.getCell(4).getStringCellValue().trim();
                                  //type=cell.getStringCellValue().trim();
                              }
                              else if (datatype.equalsIgnoreCase("")){
                                 datatype = row.getCell(5).getStringCellValue().trim();
                                 // datatype=cell.getStringCellValue().trim();
                              }else if (replicationFactor.equalsIgnoreCase("")){
                                  replicationFactor= row.getCell(6).getStringCellValue().trim();
                                  // replicationFactor=cell.getStringCellValue().trim();
                              }else if (numPartitions.equalsIgnoreCase("")){
                                   numPartitions = row.getCell(7).getStringCellValue().trim();
                                 // numPartitions=cell.getStringCellValue().trim();
                              }
                              else{
                                  System.out.println("Random data"+cell.getStringCellValue());
                              }
                              break;
                              case Cell.CELL_TYPE_NUMERIC:
                                  System.out.println("Random Data :"+cell.getNumericCellValue());

                      }*/
                      Topic topic = new Topic(source,market,project,topicName,type,datatype,replicationFactor,numPartitions);
                      topicList.add(topic);
                  }

                }

            }
          fis.close();
        }
        catch (Exception e){
          System.out.println("Exception is :"+e);
        }
        return topicList;
    }

    public static void main(String[] args) {

    List<Topic>list = readTopicConfig("C:\\Users\\Chandrashekhar\\Desktop\\topicmanager.xlsx");
  System.out.println("Topic list is :"+list);
    }

}
