package com.honeypotato.auth.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

/**
 * jwt 辅助类
 *
 * @author Lenovo on 2018/7/2.
 */
public class JwtHelper {

    private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();

    /**
     * jwt 对用户信息加密
     *
     * @param jwtPayload 用户信息
     * @param priKey     秘钥
     * @param expire     过期时间
     * @return token
     */
    public static String generateToken(JwtPayload jwtPayload, byte[] priKey, int expire) {
        return Jwts.builder().setSubject(jwtPayload.getUserId())
                .claim(JwtPayload.KEY_USER_NAME, jwtPayload.getUserName())
                .claim(JwtPayload.KEY_NICK_NAME, jwtPayload.getNickName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, priKey)
                .compact();
    }

    /**
     * 利用公钥解析JWT
     *
     * @param token  token
     * @param pubKey 公钥
     * @return 用户信息
     * @throws Exception
     */
    public static JwtPayload parserToken(String token, byte[] pubKey) throws Exception {
        Jws<Claims> jws = Jwts.parser().setSigningKey(rsaKeyHelper.getRSAKey(pubKey, RsaKeyHelper.RSA_KEY_PUB)).parseClaimsJws(token);
        return new JwtPayload(jws);
    }
}
