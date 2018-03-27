package com.shucong.mall.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Date {

    public static String getCurrentDateTimeString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(System.currentTimeMillis());
    }

    public static String timestampToDateTimeString(Timestamp timestamp) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(timestamp);
    }
}
