package com.xiazeyu.spider.model;

import lombok.Builder;
import lombok.Data;

@Data
public class PageInfo {

    private Long id;

    private String content;

    private Integer createDate;

    private Integer createTime;

    private Long updateTimeStamp;

    public static PageInfoBuilder builder(){
        return new PageInfoBuilder();
    }

    public PageInfo() {
    }

    private PageInfo(PageInfoBuilder builder) {
        this.id = builder.id;
        this.content = builder.content;
        this.createDate = builder.createDate;
        this.createTime = builder.createTime;
        this.updateTimeStamp = builder.updateTimeStamp;
    }

    public static class PageInfoBuilder {
        private Long id;
        private String content;
        private Integer createDate;
        private Integer createTime;
        private Long updateTimeStamp;

        public PageInfoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PageInfoBuilder content(String content) {
            this.content = content;
            return this;
        }

        public PageInfoBuilder createDate(Integer createDate) {
            this.createDate = createDate;
            return this;
        }

        public PageInfoBuilder createTime(Integer createTime) {
            this.createTime = createTime;
            return this;
        }

        public PageInfoBuilder updateTimeStamp(Long updateTimeStamp) {
            this.updateTimeStamp = updateTimeStamp;
            return this;
        }

        private void initDefaultValue() {
            if (content == null) {
                content = "";
            }
            if (createDate == null) {
                createDate = com.xiazeyu.spider.util.DateUtil.nowDate();
            }
            if (createTime == null) {
                createTime = com.xiazeyu.spider.util.DateUtil.nowTime();
            }
        }

        public PageInfo build() {
            initDefaultValue();
            return new PageInfo(this);
        }
    }

}
