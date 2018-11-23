package cn.novedu.security.impl;

import cn.novedu.util.JwtUtil;
import cn.novedu.constant.TokenState;
import cn.novedu.security.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 基于Jwt的TokenManager实现
 *
 * @author Max Huang
 */
@Component
public class JwtTokenManager implements TokenManager {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String createToken(String id) {
        return jwtUtil.getToken(id);
    }

    @Override
    public boolean checkToken(String token) {
        return jwtUtil.parseToken(token) == TokenState.VALID;
    }

    @Override
    public String getUserId(String token) {
        return jwtUtil.parseJWT(token).getSubject();
    }
}
