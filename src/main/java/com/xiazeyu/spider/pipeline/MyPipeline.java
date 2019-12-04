package com.xiazeyu.spider.pipeline;

import com.xiazeyu.spider.dao.PageInfoRepository;
import com.xiazeyu.spider.model.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Slf4j
public class MyPipeline implements Pipeline {

    private boolean canRunning = true;

    private long count = 100L;

    @Autowired
    private PageInfoRepository pageInfoRepository;

    @Override
    public void process(ResultItems resultItems, Task task) {
        if (!canRunning) {
            log.info("已处理页面数量:{}", count);
            return;
        }
        PageInfo pageInfo = PageInfo.builder().content(resultItems.get("content")).build();
        pageInfo = pageInfoRepository.save(pageInfo);
        if (pageInfo.getId() > count) {
            canRunning = false;
        }
    }

}
