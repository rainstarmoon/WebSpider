package com.xiazeyu.spider.pipeline;

import com.xiazeyu.spider.dao.PageInfoRepository;
import com.xiazeyu.spider.model.PageInfo;
import com.xiazeyu.spider.util.GzipUtil;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Slf4j
public class MyPipeline implements Pipeline {

    private PageInfoRepository pageInfoRepository;

    public MyPipeline(PageInfoRepository pageInfoRepository) {
        this.pageInfoRepository = pageInfoRepository;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        PageInfo pageInfo = PageInfo.builder().content(GzipUtil.compress(resultItems.get("content"))).build();
        pageInfo = pageInfoRepository.save(pageInfo);

        // todo xiazeyu
        if (pageInfo.getId() > 100) {
            System.exit(0);
        }
    }

}
