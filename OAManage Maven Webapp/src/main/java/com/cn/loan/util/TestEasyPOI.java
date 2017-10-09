package com.cn.loan.util;

import cn.afterturn.easypoi.cache.manager.POICacheManager;
import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.ExcelToHtmlParams;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestEasyPOI {

    @Test
    public void test2() throws IOException, InvalidFormatException {
       /* ExcelToHtmlParams params = new ExcelToHtmlParams(WorkbookFactory.create(POICacheManager.getFile("F:/Excel/11.xlsx")));
        System.out.print(ExcelXorHtmlUtil.excelToHtml(params).toString());*/
       System.out.print("1");
    }

    @Test
    void name() {
        System.out.print("1");
    }

    public static void main(String[] args){
        ExcelToHtmlParams params = null;
        try {
            params = new ExcelToHtmlParams(WorkbookFactory.create(POICacheManager.getFile("F:/Excel/11.xlsx")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        System.out.print(ExcelXorHtmlUtil.excelToHtml(params).toString());
    }
}
