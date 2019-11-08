package com.xiazeyu.spider;

import com.xiazeyu.spider.processor.BasePageProcessor;
import us.codecraft.webmagic.Spider;

public class WebSpiderApplication {

    public static void main(String[] args) {
        Spider.create(new BasePageProcessor()).addUrl("http://www.cnblogs.com/justcooooode/").thread(5).run();
    }

}
