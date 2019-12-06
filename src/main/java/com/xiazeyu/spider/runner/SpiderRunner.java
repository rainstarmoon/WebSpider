package com.xiazeyu.spider.runner;

import com.xiazeyu.spider.constant.SystemConstant;
import com.xiazeyu.spider.dao.PageInfoRepository;
import com.xiazeyu.spider.pipeline.MyPipeline;
import com.xiazeyu.spider.processor.MyPageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

@Component
@Order(0)
public class SpiderRunner implements ApplicationRunner {

    @Value("${spider.url-root}")
    private String urlRoot;

    @Value("${spider.url-regex}")
    private String urlRegex;

    @Value("${spider.thread-num:1}")
    private Integer threadNum;

    @Autowired
    private PageInfoRepository pageInfoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        SystemConstant.running.set(true);

        Spider.create(new MyPageProcessor(urlRegex))
                .addPipeline(new MyPipeline(pageInfoRepository))
                .addUrl(urlRoot)
                .thread(threadNum)
                .run();

        SystemConstant.running.set(false);
    }

}
