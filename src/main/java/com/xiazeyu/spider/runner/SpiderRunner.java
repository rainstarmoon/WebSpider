package com.xiazeyu.spider.runner;

import com.xiazeyu.spider.pipeline.MyPipeline;
import com.xiazeyu.spider.processor.MyPageProcessor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

@Component
@Order(1)
public class SpiderRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Spider.create(new MyPageProcessor())
                .addPipeline(new MyPipeline())
                //.addUrl("https://www.cnblogs.com/justcooooode/")
                .addUrl("https://www.zhipin.com/")
                .thread(1)
                .run();
    }

    //    public void demo() {
//        Spider spider = Spider.create(new MyPageProcessor());
//        spider.setDownloader(new MyDownloader());
//        spider.setPipelines(Collections.singletonList(new MyPipeline()));
//        spider.addUrl("https://www.cnblogs.com/justcooooode/");
//        spider.thread(1);
//        spider.run();
//    }

}
