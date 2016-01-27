package webmagic.datanalysis;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import webmagic.model.LicaiSimuInfo;
import webmagic.service.LicaiSimuService;

public class ExportData2Excel {
  
  public static void main(String[] args) {
    System.out.println("导出excel开始");
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-beans.xml");
    LicaiSimuService us = (LicaiSimuService) ac.getBean("licaiSimuService");
    List<LicaiSimuInfo> lists = us.list();
    
    // 第一步，创建一个webbook，对应一个Excel文件  
    HSSFWorkbook wb = new HSSFWorkbook();
    // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
    HSSFSheet sheet = wb.createSheet("私募");
    // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
    HSSFRow row = sheet.createRow((int) 0);
    // 第四步，创建单元格，并设置值表头 设置表头居中  
    HSSFCellStyle style = wb.createCellStyle();
    // 创建一个居中格式  
    style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
    
    HSSFCell cell = row.createCell(0);
    cell.setCellValue("基金名称");  
    cell.setCellStyle(style);  
    cell = row.createCell(1);  
    cell.setCellValue("基金类型");  
    cell.setCellStyle(style);  
    cell = row.createCell(2);  
    cell.setCellValue("最新单位净值");
    cell.setCellStyle(style);  
    cell = row.createCell(3);  
    cell.setCellValue("近一年收益");  
    cell.setCellStyle(style);  
    cell = row.createCell(4);  
    cell.setCellValue("净值时间");  
    cell.setCellStyle(style); 
    cell = row.createCell(5);  
    cell.setCellValue("单位净值");  
    cell.setCellStyle(style); 
    cell = row.createCell(6);  
    cell.setCellValue("复权净值");  
    cell.setCellStyle(style);
    cell = row.createCell(7);  
    cell.setCellValue("增长率");  
    cell.setCellStyle(style); 
    
    // 第五步，写入实体数据 实际应用中这些数据从数据库得到
    int listSize = lists.size();
    int k = 0;
    for(int i = 0; i < listSize; i++) {
      LicaiSimuInfo simuInfo = (LicaiSimuInfo) lists.get(i);  
      String[] detailDatas = simuInfo.getDetailData().replace("\n", " ").split(" ");
      List<String> removeSpace = new ArrayList<String>();
      if(detailDatas != null && detailDatas.length != 0) {
        for(int j=0; j<detailDatas.length; j++) {
          if(detailDatas[j]==null||"".equals(detailDatas[j].trim().toString())){ 
            continue; 
          } else{ 
            removeSpace.add(detailDatas[j]); 
          } 
        }
      }
      if(removeSpace != null && removeSpace.size() != 0) {
        for(int j=0; j<removeSpace.size(); j = j+4) {
          row = sheet.createRow((int) k + 1);
          k++;
          // 第四步，创建单元格，并设置值 
          if(j == 0) {
            row.createCell(0).setCellValue(simuInfo.getTitle());  
            row.createCell(1).setCellValue(simuInfo.getType());  
            row.createCell(2).setCellValue(simuInfo.getNav());  
            row.createCell(3).setCellValue(simuInfo.getEarnings());
          }else {
            row.createCell(0).setCellValue("");  
            row.createCell(1).setCellValue("");  
            row.createCell(2).setCellValue("");  
            row.createCell(3).setCellValue("");
          }
          row.createCell(4).setCellValue(removeSpace.get(j));
          row.createCell(5).setCellValue(removeSpace.get(j+1));
          row.createCell(6).setCellValue(removeSpace.get(j+2));
          row.createCell(7).setCellValue(removeSpace.get(j+3));
        }
      }
    }  
    // 第六步，将文件存到指定位置  
    try {  
      FileOutputStream fout = new FileOutputStream("D:/webmagic/simu.xls");  
      wb.write(fout);  
      fout.close();
      System.out.println("导出excel结束");
    }catch (Exception e) {  
      e.printStackTrace();  
      System.out.println("导出excel发生错误:" + e);
    }  
    
  }
  
}
