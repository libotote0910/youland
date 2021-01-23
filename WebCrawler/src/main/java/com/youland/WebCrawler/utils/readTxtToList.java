package com.youland.WebCrawler.utils;

import com.youland.WebCrawler.webCrawlerUrlList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class readTxtToList {
    public static List<webCrawlerUrlList> getList() {
        //将读取数据依次放到List中
        List<String> list = new ArrayList<String>();
        //存放最终的数据
        List<webCrawlerUrlList> tList = new ArrayList<webCrawlerUrlList>();
        //最终结果转换成json
        String json = null;

        File f = new File("./web_crawler_url_list.txt");
        BufferedReader br = null;
        InputStreamReader isr = null;

        try {
            // 创建一个文件读取流对象，和指定文件名的文件相关联
            isr = new InputStreamReader(new FileInputStream(f), "gbk");
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                //一行一行读取内容，把内容存放到list中
                list.add(line);
            }

            // 使用foreach遍历List，分割list中的每一个元素
            for (String str : list) {
                //以逗号分隔
                String[] arrStr = str.split(",");
                //返回对象
                //System.out.println(arrStr[0]);
                webCrawlerUrlList p = new webCrawlerUrlList(arrStr[0],arrStr[1],arrStr[2],arrStr[3],arrStr[4],arrStr[5]);
                tList.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 关闭资源
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tList;
    }
}
