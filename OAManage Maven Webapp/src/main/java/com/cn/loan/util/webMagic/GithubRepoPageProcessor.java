package com.cn.loan.util.webMagic;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {

	// 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        
        // 部分二：定义如何抽取页面信息，并保存下来
       /* page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());*/
    	List<String> titles = page.getHtml().xpath("//div[@class='ui four cards all-projects']/div[@class='ui fluid card']/div[@class='content description-content']/div[@class='header']/a/text()").all();
    	List<String> descriptions =  page.getHtml().xpath("//div[@class='ui four cards all-projects']/div[@class='ui fluid card']/div[@class='content description-content']/div[@class='description']/p/text()").all();
    	for (int i = 0;i<titles.size();i++) {
			System.out.println(titles.get(i).toString());
			System.out.println(descriptions.get(i).toString());
		}
/*        page.putField("title", page.getHtml().xpath("//div[@class='ui four cards all-projects']/div[@class='ui fluid card']/div[@class='content description-content']/div[@class='header']/a/text()").all().toString());
        page.putField("description", page.getHtml().xpath("//div[@class='ui four cards all-projects']/div[@class='ui fluid card']/div[@class='content description-content']/div[@class='description']/p/text()").all().toString());
        if (page.getResultItems().get("title")==null){
            //skip this page
            page.setSkip(true);
        }*/
        
        /*page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));*/
        // 部分三：从页面发现后续的url地址来抓取
        /*page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());*/
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new GithubRepoPageProcessor()).addUrl("https://gitee.com/gvp").thread(5).run();
    }
}
