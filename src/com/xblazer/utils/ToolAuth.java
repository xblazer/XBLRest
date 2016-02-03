package com.xblazer.utils;

import com.jfinal.kit.PropKit;
import com.xblazer.core.common.AppConstants;
import com.xblazer.core.common.DictKeys;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求权限相关处理类
 *
 * @author NCIT
 *
 */
public class ToolAuth {

    /** 认证key */
    private static final String authKey = PropKit.get(DictKeys.auth_key);

    /** 认证用密文各位置索引 */
    private static final int SIGNATURE_BEGIN_INDEX = 0;
    private static final int SIGNATURE_END_INDEX = 64;
    private static final int SALT_BEGIN_INDEX = SIGNATURE_END_INDEX;

    /**
     * 进行权限认证
     *
     * @param req
     *            请求对象
     * @throws Exception
     *             权限异常
     */
    public static void auth(HttpServletRequest req)
            throws Exception {

        // 请求完整密文
        String signKey = req.getHeader(AppConstants.HEADER_SIGN_KEY);
        if (signKey == null){
            throw new Exception("");
        }
        // 请求原始数据
        String requestBody = req
                .getParameter(AppConstants.REQUEST_PARAMETER_KEY);
        // 如没有请求原始数据，设置为空
        if (StringUtils.isEmpty(requestBody)) {
            requestBody = StringUtils.EMPTY;
        }
        // 请求地址
        String signUri = ToolWeb.getAuthReqCtx(req);

        // 请求密文
        String signature = signKey.substring(SIGNATURE_BEGIN_INDEX,
                SIGNATURE_END_INDEX);
        // 请求盐
        String salt = signKey.substring(SALT_BEGIN_INDEX);
        // 拼接原始数据
        String data = null;
        if (StringUtils.isEmpty(requestBody)) {
            data = signUri;
        } else {
            data = requestBody + signUri;
        }

        // 验证请求是否有效
        validateSignature(authKey, data, salt, signature);
    }

    /**
     * 验证请求是否有效
     *
     * @param authKey
     *            密钥
     * @param data
     *            请求原始数据
     * @param salt
     *            盐
     * @param signature
     *            请求完整密文
     * @throws Exception
     *             验证异常
     */
    private static void validateSignature(String authKey, String data,
            String salt, String signature) throws Exception {

        try {
            boolean isSameSignature = ToolSignatureUtil.isSameSignature(authKey,
                    data, salt, signature);
            if (!isSameSignature) {
                throw new Exception("");
            }
        } catch (Exception e) {
            throw new Exception("");
        }
    }
}
