package cn.novedu.util;


import org.springframework.util.SerializationUtils;

/**
 * 序列化工具类
 * @author Max Huang
 */
public final class SerializationUtil {
    /**
     * 序列化
     */
    public static byte[] serialize(Object object) {
        return SerializationUtils.serialize(object);
    }

    /**
     * 反序列化
     */
    public static Object deserialize(byte[] bytes) {
        return SerializationUtils.deserialize(bytes);
    }
}
