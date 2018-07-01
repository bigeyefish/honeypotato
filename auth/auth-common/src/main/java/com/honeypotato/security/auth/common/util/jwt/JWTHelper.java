package com.honeypotato.security.auth.common.util.jwt;

import com.honeypotato.security.auth.common.constants.CommonConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

/**
 * Created by Lenovo on 2018/7/2.
 */
public class JWTHelper {

    private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();

    /**
     * 加密token
     * @param jwtInfo
     * @param priKeyPath
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(IJWTInfo jwtInfo, String priKeyPath, int expire) throws Exception {
        return Jwts.builder().setSubject(jwtInfo.getUnitqueName())
                .claim(CommonConstants.JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(CommonConstants.JWT_KEY_NAME, jwtInfo.getName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getRSAKey(priKeyPath, RsaKeyHelper.RSA_KEY_PRI))
                .compact();
    }
}
