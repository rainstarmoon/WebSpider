package com.xiazeyu.spider.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

public class MyPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        Selectable links = html.links();
        // todo xiazeyu
        Selectable regex = links.regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)");
        page.addTargetRequests(regex.all());
        page.putField("content", page.getHtml());
    }

}
