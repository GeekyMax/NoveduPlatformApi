package cn.novedu.util;

import cn.novedu.constant.TokenState;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class JwtUtilTest {

    @Test
    public void getToken() {
        JwtUtil jwtUtil = new JwtUtil();
        String token = jwtUtil.getToken("3160102211");
        TokenState tokenState = jwtUtil.parseToken(token);
    }
}