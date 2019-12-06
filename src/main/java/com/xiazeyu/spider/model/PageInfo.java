package com.xiazeyu.spider.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class PageInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private byte[] content;
    private Integer createDate;
    private Integer createTime;
    private Date updateTimestamp;

    public static PageInfoBuilder builder() {
        return new PageInfoBuilder();
    }

    public PageInfo() {
    }

    private PageInfo(PageInfoBuilder builder) {
        this.id = builder.id;
        this.content = builder.content;
        this.createDate = builder.createDate;
        this.createTime = builder.createTime;
        this.updateTimestamp = builder.updateTimestamp;
    }

    public static class PageInfoBuilder {
        private Integer id;
        private byte[] content;
        private Integer createDate;
        private Integer createTime;
        private Date updateTimestamp;

        public PageInfoBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public PageInfoBuilder content(byte[] content) {
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

        public PageInfoBuilder updateTimestamp(Date updateTimestamp) {
            this.updateTimestamp = updateTimestamp;
            return this;
        }

        private void initDefaultValue() {
            if (content == null) {
                content = new byte[0];
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
