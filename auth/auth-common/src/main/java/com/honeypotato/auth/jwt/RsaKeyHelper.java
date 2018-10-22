package com.honeypotato.auth.jwt;

import com.honeypotato.auth.common.AuthResultEnum;
import com.honeypotato.auth.exception.AuthException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2018/7/2.
 */
public class RsaKeyHelper {

    static final String RSA_KEY_PUB = "public";
    static final String RSA_KEY_PRI = "private";

    private static final String ENCRYPT_TYPE = "RSA";

    /**
     * 获取公钥或秘钥
     * @param filename 秘钥文件
     * @param type key类型
     * @return 秘钥KEY
     * @throws Exception exception
     */
    // public Key getRSAKey(String filename, String type) throws Exception {
    //     byte[] keyBytes = FileUtils.readFileToByteArray(new File(filename));
    //     return getRSAKey(keyBytes, type);
    // }

    /**
     * 获取公钥或秘钥
     * @param keyByte key字节码
     * @param type key类型
     * @return key
     * @throws AuthException 权限异常
     */
    public Key getRSAKey(byte[] keyByte, String type) {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyByte);
        KeyFactory kf;
        try {
            kf = KeyFactory.getInstance(ENCRYPT_TYPE);
            if (RSA_KEY_PUB.equals(type)) {
                return kf.generatePublic(spec);
            } else if (RSA_KEY_PRI.equals(type)) {
                return kf.generatePrivate(spec);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            throw new AuthException(e.getMessage(), AuthResultEnum.GENERATE_KEY_ERROR);
        }
        return null;
    }

    /**
     * 生成RSA公钥或秘钥
     * @param password
     * @param type
     * @return
     * @throws NoSuchAlgorithmException
     * @throws AuthException
     */
    public static byte[] generateRSAKey(String password, String type) throws NoSuchAlgorithmException, AuthException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ENCRYPT_TYPE);
        SecureRandom secureRandom = new SecureRandom(password.getBytes());
        keyPairGenerator.initialize(1024, secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        if (RSA_KEY_PUB.equals(type)) {
            return keyPair.getPublic().getEncoded();
        } else if (RSA_KEY_PRI.equals(type)) {
            return keyPair.getPrivate().getEncoded();
        }
        return null;
    }

    /**
     * 生成公钥秘钥对
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static Map<String, byte[]> generateKey(String password) throws NoSuchAlgorithmException, AuthException {
        Map<String, byte[]> map = new HashMap<>(2);
        map.put("pub", generateRSAKey(password, RSA_KEY_PUB));
        map.put("pri", generateRSAKey(password, RSA_KEY_PRI));
        return map;
    }

    public static String toHexString(byte[] b) {
        return (new BASE64Encoder()).encodeBuffer(b);
    }

    public static final byte[] toBytes(String s) throws IOException {
        return (new BASE64Decoder()).decodeBuffer(s);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ENCRYPT_TYPE);
        SecureRandom secureRandom = new SecureRandom("123".getBytes());
        keyPairGenerator.initialize(1024, secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        System.out.println(keyPair.getPublic().getEncoded());
    }
}
