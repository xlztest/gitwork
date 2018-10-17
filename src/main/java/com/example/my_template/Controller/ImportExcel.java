package com.example.my_template.Controller;

import com.example.my_template.Service.UserService;
import com.example.my_template.entity.Total;
import com.example.my_template.entity.Uv;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * 导出Excel表
 */

@Slf4j
@RestController
public class ImportExcel extends BaseController{

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/excelDownloads", method = RequestMethod.GET)
    public void downloadAllClassmate(HttpServletResponse response, @Param("time")String time) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        if(time==null){
            return;
        }
        List<Total> classmateList = userService.selectAll(time);

        String fileName = "Total"  + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = { "点击名称", "点击量", "日期"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (Total total : classmateList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(total.getLocation());
            row1.createCell(1).setCellValue(total.getTotal());
            row1.createCell(2).setCellValue(total.getTime());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    @RequestMapping(value = "/excelDownloadsZl", method = RequestMethod.GET)
    public void downloadZL(HttpServletResponse response, @Param("time")String time) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        if(time==null){
            return;
        }
        List<Total> classmateList = userService.selectzlAll(time);

        String fileName = "Total"  + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = { "点击名称", "点击量", "日期"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (Total total : classmateList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(total.getLocation());
            row1.createCell(1).setCellValue(total.getTotal());
            row1.createCell(2).setCellValue(total.getTime());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    @RequestMapping(value = "/excelDownloadsZLUV", method = RequestMethod.GET)
    public void downloadZLUV(HttpServletResponse response, @Param("time")String time) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        if(time==null){
            return;
        }
        List<Uv> classmateList = userService.selectzlUV(time);

        String fileName = "Total"  + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = { "客户名称", "用户量", "日期"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (Uv uv : classmateList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(uv.getCustomer());
            row1.createCell(1).setCellValue(uv.getTotal());
            row1.createCell(2).setCellValue(uv.getTime());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }





    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
   public  String test(){
        return "sadada";
    }








}
