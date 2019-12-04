package com.xiazeyu.spider.downloader;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.Downloader;

@Deprecated
public class MyDownloader implements Downloader {

    @Override
    public Page download(Request request, Task task) {
        Page page = new Page();
        return page;
    }

    @Override
    public void setThread(int i) {
    }
}
