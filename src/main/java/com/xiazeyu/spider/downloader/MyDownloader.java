package com.xiazeyu.spider.downloader;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.selector.PlainText;

public class MyDownloader implements Downloader {

    int i=0;

    @Override
    public Page download(Request request, Task task) {
        System.out.println(i++);
        Page page = new Page();
        page.setUrl(new PlainText(request.getUrl()));
        // todo


        return page;
    }

    @Override
    public void setThread(int i) {
    }
}
