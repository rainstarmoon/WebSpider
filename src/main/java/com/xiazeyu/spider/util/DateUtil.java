package com.xiazeyu.spider.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("YYYYMMdd");

    public static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmmss");

    public static Integer nowDate() {
        LocalDateTime rightNow = LocalDateTime.now();
        String format = dateFormatter.format(rightNow);
        return Integer.valueOf(format);
    }

    public static Integer nowTime() {
        LocalDateTime rightNow = LocalDateTime.now();
        String format = timeFormatter.format(rightNow);
        return Integer.valueOf(format);
    }

}
