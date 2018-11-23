package cn.novedu.security;

/**
 * 用于生成,验证 Token
 * @author Max Huang
 *
 */
public interface TokenManager {
    /**
     * 根据传入的id创建token
     * @param id
     * @return
     */
    String createToken(String id);

    /**
     * 根据传入的token验证token有效性
     * @param token
     * @return
     */
    boolean checkToken(String token);

    /**
     * 解析token中的用户信息(这里是id)
     * @param token
     * @return
     */
    String getUserId(String token);
}
