package cn.novedu.util;

import cn.novedu.constant.TokenState;
import cn.novedu.mapper.UserMapper;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Max Huang
 */
@Component
public class JwtUtil {
    public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";
    public static final long TTL_MILLIS = 60 * 60 * 1000;
    private Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    @Autowired
    UserMapper userMapper;

    /**
     * 创建jwt
     *
     * @param id
     * @param subject
     * @param ttlMillis 过期的时间长度
     * @return
     * @throws Exception
     */
    private String createJWT(String uid, String id, String subject, long ttlMillis) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        long nowMillis = System.currentTimeMillis();
        //生成JWT的时间
        Date now = new Date(nowMillis);
        Map<String, Object> claims = new HashMap<String, Object>();
        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        claims.put("uid", uid);
        SecretKey key = generalKey();
        //生成签名的时候使用的秘钥secret,这个方法本地封装了的，一般可以从本地配置文件中读取，切记这个秘钥不能外露哦。它就是你服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
        //下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder()
                //这里其实就是new一个JwtBuilder，设置jwt的body
                .setClaims(claims)
                //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setId(id)
                //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setIssuedAt(now)
                //iat: jwt的签发时间
                .setSubject(subject)
                //sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .signWith(signatureAlgorithm, key);
        //设置签名使用的签名算法和签名使用的秘钥
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
            //设置过期时间
        }
        return builder.compact();
        //打印了一哈哈确实是下面的这个样子
    }

    /**
     * 解密jwt
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public Claims parseJWT(String jwt) {
        //签名秘钥，和生成的签名的秘钥一模一样
        SecretKey key = generalKey();
        //得到DefaultJwtParser
        Claims claims = Jwts.parser()
                //设置签名的秘钥
                .setSigningKey(key)
                //设置需要解析的jwt
                .parseClaimsJws(jwt).getBody();
        logger.debug("claims subject:"+claims.getSubject());
        logger.debug("claims id:"+claims.getId());
        logger.debug("claims expiration:"+claims.getExpiration());
        logger.debug("claims issued at:"+claims.getIssuedAt());
        return claims;
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    private SecretKey generalKey() {
        //本地配置文件中加密的密文7786df7fc3a34e26a61c034d5ec8245d
        String stringKey = JWT_SECRET;
        //本地的密码解码[B@152f6e2
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        // 根据给定的字节数组使用AES加密算法构造一个密钥，使用 encodedKey中的始于且包含 0 到前 leng 个字节这是当然是所有。（后面的文章中马上回推出讲解Java加密和解密的一些算法）
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public static void main(String[] args) throws Exception {
        JwtUtil util = new JwtUtil();
        String ab = util.createJWT("1", "jwt", "{id:100,name:xiaohong}", 60000);
        System.out.println(ab);
        //eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJEU1NGQVdEV0FEQVMuLi4iLCJzdWIiOiJ7aWQ6MTAwLG5hbWU6eGlhb2hvbmd9IiwidXNlcl9uYW1lIjoiYWRtaW4iLCJuaWNrX25hbWUiOiJEQVNEQTEyMSIsImV4cCI6MTUxNzgzNTE0NiwiaWF0IjoxNTE3ODM1MDg2LCJqdGkiOiJqd3QifQ.ncVrqdXeiCfrB9v6BulDRWUDDdROB7f-_Hg5N0po980
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJEU1NGQVdEV0FEQVMuLi4iLCJzdWIiOiJ7aWQ6MTAwLG5hbWU6eGlhb2hvbmd9IiwidXNlcl9uYW1lIjoiYWRtaW4iLCJuaWNrX25hbWUiOiJEQVNEQTEyMSIsImV4cCI6MTUzOTgzMzgyMywiaWF0IjoxNTM5ODMzNzYzLCJqdGkiOiJqd3QifQ.RzvlaqckhKl-0uN6aXwPjjy_RIupS29agBLVcO6LdL4";
        try {
            //注意：如果jwt已经过期了，这里会抛出jwt过期异常。
            Claims c = util.parseJWT(jwt);

            System.out.println(c.getId());
            System.out.println(c.getIssuedAt());
            System.out.println(c.getSubject());
            //{id:100,name:xiaohong}
            System.out.println(c.getIssuer());
            //null
            System.out.println(c.get("uid", String.class));
            //DSSFAWDWADAS...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getToken(String uid) {
        try {
            String randomString = RandomStringUtils.randomAlphanumeric(10);
            logger.debug("random string: " + randomString);
            return createJWT(uid, randomString, uid, TTL_MILLIS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TokenState parseToken(String token) {
        TokenState tokenState = null;
        try {
            Claims claims = parseJWT(token);
            String uid = claims.getSubject();
            return TokenState.VALID;
        } catch (ExpiredJwtException e) {
            tokenState = TokenState.EXPIRED;
            e.printStackTrace();
        } catch (Exception e) {
            tokenState = TokenState.INVALID;
            e.printStackTrace();
        }
        return tokenState;
    }
}
