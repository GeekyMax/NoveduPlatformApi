package cn.novedu.security.impl;

import cn.novedu.util.StringUtil;
import cn.novedu.security.TokenManager;
import cn.novedu.util.CodecUtil;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Max Huang
 */
public class DefaultTokenManager implements TokenManager {
    private static Map<String, String> tokenMap = new ConcurrentHashMap<>();

    @Override
    public String createToken(String id) {
        String token = CodecUtil.createUUID();
        tokenMap.put(token, id);
        return token;
    }

    @Override
    public boolean checkToken(String token) {
        return !StringUtil.isEmpty(token) && tokenMap.containsKey(token);
    }

    @Override
    public String getUserId(String token) {
        if (StringUtil.isNotEmpty(token) && tokenMap.containsKey(token)) {
            return tokenMap.get(token);
        }
        return null;
    }
}
