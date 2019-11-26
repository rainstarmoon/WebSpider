package com.xiazeyu.spider.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class MyPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    int i = 0;

    @Override
    public void process(Page page) {
        page.addTargetRequest("http://www.cnblogs.com/justcooooode/" + i + "/");
    }

    @Override
    public Site getSite() {
        return site;
    }

}
