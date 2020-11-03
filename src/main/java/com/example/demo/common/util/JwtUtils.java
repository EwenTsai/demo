package com.example.demo.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtils {

    /**
     * 一小时时间戳大小
     */
    public static final long HOUR_TIMESTAMP = 3600000;

    /**
     * Token存储在Request Header别称
     */
    public static final String AUTHORIZATION = "Authorization";

    /**
     * 从request header获取token
     * @param request 请求
     * @return { token }
     */
    public static String getRequestToken(HttpServletRequest request) {
        return request.getHeader(AUTHORIZATION);
    }

    /**
     * 生成用户令牌
     * @param user 用户
     * @param hours 多少小时后过期
     * @return { token }
     */
    public static String generateToken(User user, long hours) {
        Date now = new Date();
        return JWT.create()
                .withIssuedAt(now)
                .withAudience(user.getNickname())
                .withJWTId(RandomUtils.uuid())
                .withExpiresAt(new Date(now.getTime() + hours * HOUR_TIMESTAMP))
                .sign(Algorithm.HMAC256(user.getPassword()));
    }

    /**
     * token是否过期
     * @param token 令牌
     * @return { true or false }
     */
    public static boolean isTokenExpired(String token) {
        Date expires = JWT.decode(token).getExpiresAt();
        return expires.before(new Date());
    }

}
