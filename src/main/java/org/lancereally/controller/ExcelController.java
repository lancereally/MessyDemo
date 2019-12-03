package org.lancereally.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.lancereally.service.ExcelImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
//value属性就是five
@Api(tags = "表格导出")
public class ExcelController {
    //这里直接new了
    ExcelImpl excelImpl =new ExcelImpl();

    @RequestMapping(value="/download_excel")
    @ApiOperation(value="导出表格",notes="导出表格需要ID和姓名", httpMethod = "POST")
//获取url链接上的参数
    public @ResponseBody String down(HttpServletResponse response, @ApiParam(value = "ID", required = true)@RequestParam("id") String id, @ApiParam(value = "用户名", required = true)@RequestParam("name") String name){
        response.setContentType("application/binary;charset=UTF-8");
        try{
            ServletOutputStream out=response.getOutputStream();
            try {
                //设置文件头：最后一个参数是设置下载文件名(这里设置：张三.xls)
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(id+name+".xls", "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            String[] titles = { "用户id", "用户姓名", "用户密码", "用户年龄" };
            excelImpl.export(titles, out);
            return "success";
        } catch(Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }

    @RequestMapping("/example")
    @ApiOperation(value="返回信息demo",notes="返回形式为json", httpMethod = "POST")
    public @ResponseBody HashMap json(){
        HashMap ex = new HashMap();
        ex.put("message","success");
        return  ex;
    }
}
