package com.youland.WebCrawler.utils;

import com.youland.WebCrawler.webCrawlerUrlList;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class readWebPage {
    public static void writeToTxt(String url) {
        try {
            url = "https://www." + url.replaceAll("\"","");
            System.out.println("Crawling web url is: " + url);
            //想要读取的url地址
            URL url1 = new URL(url);
            //读取文件到那个路径 自己定义
            File fp = new File("./results.txt");
            //建立文件输出流
            OutputStream os = new FileOutputStream(fp, true);
            //打开url连接
            URLConnection conn = url1.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String urlString = "";
            String current;
            while ((current = in.readLine()) != null) {
                urlString += current;
            }
            //System.out.println(urlString);
            os.write(urlString.getBytes());
            os.close();

            System.out.println("Crawling " + url + "Success,the crawled file is on the current directory file results.txt!");

        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Crawling web pages Failed!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Crawling web pages Failed!");
        }
    }
}
