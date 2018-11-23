package cn.novedu.util;

import org.apache.commons.lang3.RandomStringUtils;

public final class RandomUtil {

    private RandomUtil() {
    }

    /**
     * 生成随机数
     */
    public static String getRandom(int count) {
        return RandomStringUtils.randomNumeric(count);
    }
}
