package com.youland.WebCrawler;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.youland.WebCrawler.utils.readTxtToList;
import com.youland.WebCrawler.utils.readWebPage;

import java.util.List;
import java.util.regex.*;


@SpringBootApplication
public class WebCrawlerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(WebCrawlerApplication.class, args);
		// 判断是否有参数
		if (args[0].equals(null)) {
			System.out.println("please input a rank number or all");
			return;
		}
		//System.out.println(args[0]);

		// 读取txt文件
		List<webCrawlerUrlList> txtlist = readTxtToList.getList();
		if (txtlist!=null && !txtlist.isEmpty()) {
			// 抓取所有网站
			if (args[0].equals("all")) {
				for(int i=1; i<txtlist.size(); i++) {
					if (txtlist.get(i).getURL() != null) {
						// 写入results.txt文件
						readWebPage.writeToTxt(txtlist.get(i).getURL());
					}
				}
				// 抓取某个网站
			} else if (isInteger(args[0])) {
				int rank = Integer.parseInt(args[0]);
				System.out.println("the selected rank is：" + args[0]);

				if (rank <= 0 || rank > (txtlist.size() -1) ) {
					System.out.println("the selected rank is out");
					return;
				}

				if (txtlist.get(rank).getURL() != null) {
					// 写入results.txt文件
					readWebPage.writeToTxt(txtlist.get(rank).getURL());
				} else {
					System.out.println("the selected URL is invalid");
					return;
				}
			}
			else {
				System.out.println("the parameter must be number or all!");
				return;
			}

		}
		else {
			System.out.println("read txt file web_crawler_url_list.txt failed!");
			return;
		}

	}

	// 判断字符串是否为数字
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

}
