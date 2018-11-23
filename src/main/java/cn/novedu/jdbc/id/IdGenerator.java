package cn.novedu.jdbc.id;

import java.util.List;

/**
 * ID 生成器接口
 *
 * @author huangyong
 * @since 1.0.0
 */
public interface IdGenerator {

    String generateId();

    List<String> generateIdList(int count);
}
