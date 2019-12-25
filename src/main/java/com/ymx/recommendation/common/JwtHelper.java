package com.ymx.recommendation.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: recommendation
 * @description:
 * @author: victor
 * @create: 2019-12-25 16:46
 **/
@Data
@AllArgsConstructor
public class JwtHelper {

    private String secret;

    private long expire;

    /**
     * 生成 token
     *
     * @param userId 用户id
     * @return jwt token的结果
     */
    public String sign(long userId) {
        // 过期时间
        Date date = new Date(System.currentTimeMillis() + expire);
        // 私钥及加密算法
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "jwt");
            header.put("alg", "HMAC256");

            return JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 验证token
     *
     * @param token token值
     * @return UserId
     * @throws CommonException 抛出自定义异常
     */
    public Long validate(String token) throws CommonException {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            return jwtVerifier.verify(token).getClaim("userId").asLong();
        } catch (TokenExpiredException e) {
            throw new CommonException(ErrorEnum.TOKEN_EXPIRED);
        } catch (JWTVerificationException e) {
            throw new CommonException(ErrorEnum.TOKEN_FAILED);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

}
