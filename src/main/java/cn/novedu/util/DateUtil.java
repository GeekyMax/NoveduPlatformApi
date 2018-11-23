package cn.novedu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private DateUtil() {
    }

    /**
     * 获取当前日期与时间
     */
    public static String getCurrentDateTime() {
        return dateTimeFormat.format(new Date());
    }
}
