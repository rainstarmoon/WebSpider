package com.xiazeyu.spider.controller;

import com.xiazeyu.spider.constant.SystemConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpiderController {

    @GetMapping({"checkStatus", "checkstatus", "check", "status"})
    public String checkStatus() {
        String value = null;
        if (SystemConstant.running.get()) {
            value = "正在运行";
        } else {
            value = "已经停止";
        }
        return "目前的系统" + value;
    }

}
