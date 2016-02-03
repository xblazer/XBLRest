package com.xblazer.utils;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 数据加密工具类
 * 
 * @author NCIT
 *
 */
public class ToolSignatureUtil {

    private static final Logger tools_log = LoggerFactory.getLogger("TOOLS");
    
    /** 算法A */
    private static final String ALGORITHM = "HmacSHA256";

    /** 算法B */
    private static final String SHA = "SHA-256";

    /**
     * 无盐数据加密
     *
     * @param key
     *            密钥
     * @param data
     *            原始数据
     * @return 密文
     * @throws NoSuchAlgorithmException
     *             加密异常
     * @throws InvalidKeyException
     *             无效密钥异常
     * @throws UnsupportedEncodingException 
     *             无效密钥异常
     * @throws IllegalStateException 
     *             无效密钥异常
     */
    public static String signedWithHmac(String key, String data) throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException, UnsupportedEncodingException {
        return signedWithHmac(key, data, null);
    }

    /**
     * 数据加密
     *
     * @param key
     *            密钥
     * @param data
     *            原始数据
     * @param salt
     *            盐
     * @return 密文
     * @throws NoSuchAlgorithmException
     *             加密异常
     * @throws InvalidKeyException
     *             无效密钥异常
     * @throws UnsupportedEncodingException 
     *             无效密钥异常
     * @throws IllegalStateException 
     *             无效密钥异常
     */
    public static String signedWithHmac(String key, String data, String salt)
            throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException, UnsupportedEncodingException {
        Mac hmacSHA256 = Mac.getInstance(ALGORITHM);
        byte[] keyBytes;
        if (salt != null) {
            keyBytes = (salt + key).getBytes();
        } else {
            keyBytes = key.getBytes();
        }
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
        hmacSHA256.init(secretKey);
        return Hex.encodeHexString(hmacSHA256.doFinal(data.getBytes("UTF-8")));
    }

    /**
     * 判断是否相同密文
     *
     * @param authenticationKey
     *            认证密钥
     * @param data
     *            待加密数据
     * @param salt
     *            盐
     * @param signature
     *            密文
     * @return 密文相同true，反之为false
     * @throws NoSuchAlgorithmException
     *             加密异常
     * @throws InvalidKeyException
     *             无效密钥异常
     * @throws UnsupportedEncodingException 
     *             无效密钥异常
     * @throws IllegalStateException 
     *             无效密钥异常
     */
    public static boolean isSameSignature(String authenticationKey,
            String data, String salt, String signature)
            throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException, UnsupportedEncodingException {

        String signedWithHmac = signedWithHmac(authenticationKey, data, salt);

        if (signature.equals(signedWithHmac)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 加密处理地
     *
     * @param orignal
     *            原始数据
     * @return 加密结果
     */
    public static String shaEncrypt(String orignal) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(SHA);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            tools_log.error(ToolSignatureUtil.class.getName(), e);
        }
        if (null != md) {
            byte[] origBytes = orignal.getBytes();
            md.update(origBytes);
            byte[] digestRes = md.digest();
            String digestStr = getDigestStr(digestRes);
            return digestStr;
        }
        return null;
    }

    /**
     * 摘要处理
     *
     * @param origBytes
     *            原始数据
     * @return 处理结果
     */
    private static String getDigestStr(byte[] origBytes) {
        String tempStr = null;
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < origBytes.length; i++) {
            tempStr = Integer.toHexString(origBytes[i] & 0xff);
            if (tempStr.length() == 1) {
                stb.append("0");
            }
            stb.append(tempStr);
        }
        return stb.toString();
    }

}
