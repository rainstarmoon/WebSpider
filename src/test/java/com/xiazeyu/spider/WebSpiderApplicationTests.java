package com.xiazeyu.spider;

import com.xiazeyu.spider.dao.PageInfoRepository;
import com.xiazeyu.spider.model.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebSpiderApplicationTests {

    @Autowired
    private PageInfoRepository pageInfoRepository;

    @Test
    public void contextLoads() {

    }

}
