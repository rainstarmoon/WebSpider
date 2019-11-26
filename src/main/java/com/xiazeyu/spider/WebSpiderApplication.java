package com.xiazeyu.spider;

import com.xiazeyu.spider.downloader.MyDownloader;
import com.xiazeyu.spider.pipeline.MyPipeline;
import com.xiazeyu.spider.processor.MyPageProcessor;
import us.codecraft.webmagic.Spider;

import java.util.Collections;

public class WebSpiderApplication {

    public static void main(String[] args) {
        Spider spider = Spider.create(new MyPageProcessor());
        spider.setDownloader(new MyDownloader());
        spider.setPipelines(Collections.singletonList(new MyPipeline()));
        spider.addUrl("http://www.cnblogs.com/justcooooode/");
        spider.thread(1);
        spider.run();
    }

}
