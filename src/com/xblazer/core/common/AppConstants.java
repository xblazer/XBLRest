package com.xblazer.core.common;

public class AppConstants {

    public static final String HEADER_SIGN_KEY = "X-Sign-Id";
    public static final String API_PREFIX = "/api/";
    public static final String REQUEST_PARAMETER_KEY = "json";
    public static final String QUERY_START_STRING = "?";
    public static final String HEADER_AUTHORIZATION_KEY = "Authorization";
    /**
     * 允许上传图片类型
     */
    public static final String[] IMG_FILE_EXT = {"gif", "jpg", "jpeg", "png", "bmp"};
    /**
     * 短信验证平台接口
     */
    public static final String SMS_SERVER_API = "http://123.57.46.116:8080/doctortree-doctor/resource/sendmsg/v2.json";
    public static final String SMS_TEMPLATE_ID = "3";
    public static final String SMS_TEMPLATEDATA_MINUTE = ",5秒";
    public static final String SMS_START_TXT = "SHSsendmsgV2ysh";
    /**
     * 图片剪切后缀
     */
    public static final String IMAGE_SUFFIX_S = "_s";
    public static final String IMAGE_SUFFIX_M = "_m";
    public static final String IMAGE_SUFFIX_L = "_l";
    /**
     * 请求认证相关
     */
    public static String PROPERTIES_FILE_NAME_CORS = "cors.properties";
    public static String AUTH_HEADER_WHERE_KEY = "__W__";
    public static String AUTH_HEADER_WHERE_BACK = "__B__";
    public static String AUTH_HEADER_WHERE_FRONT = "__F__";
    public static String SESSION_KEY = "__SESSION__";
    /**
     * 结果
     */
    public static int NG = 0;
    public static int OK = 1;
    /**
     * 用户种别
     */
    public static String USER_TYPE_NORMAL = "0";
    public static String USER_TYPE_MANAGER = "1";
    /**
     * 删除FLAG
     */
    public static String DELETE_FLAG_VALID = "0";
    public static String DELETE_FLAG_INVALID = "1";
    /**
     * 订单状态
     */
    public static String ORDER_STATUS_WAITING_PAY = "1";        // 待支付
    public static String ORDER_STATUS_WAITING_CONFIRM = "2";    // 已支付（待确认）
    public static String ORDER_STATUS_COMPLETED = "3";          // 已确认（已完成）
    public static String ORDER_STATUS_REFUND_PROCESSING = "4";  // 机构处理中
    public static String ORDER_STATUS_REFUND_CONFIRM = "5";     // 退款待确认
    public static String ORDER_STATUS_REFUND_ACCEPTED = "6";    // 退款办理中
    public static String ORDER_STATUS_REFUNDED = "7";           // 已退款
    public static String ORDER_STATUS_CANCELED = "8";           // 已取消
    /**
     * 收藏种别
     */
    public static String FAVORITE_TYPE_AGENT = "1";             // 机构
    public static String FAVORITE_TYPE_COURSE = "2";            // 课程
    /**
     * 扫码状态
     */
    public static String SCAN_STATUS_INVALID = "0";             // 未扫码
    public static String SCAN_STATUS_VALID = "1";               // 已扫码
    /**
     * 收支种别
     */
    public static String PAYMENTS_FLAG_EXPENSE = "1";           // 收入
    public static String PAYMENTS_FLAG_RECEIPT = "2";           // 支出
    /**
     * 收支类型
     */
    public static String PAYMENTS_TYPE_REWARD = "1";            // 红包
    public static String PAYMENTS_TYPE_BALANCE = "3";           // 购买课程款(钱包)
    public static String PAYMENTS_TYPE_CASH = "4";              // 购买课程款(现金)
    public static String PAYMENTS_TYPE_REFUND = "5";            // 课程退款
    public static String PAYMENTS_TYPE_RECHARGE = "6";          // 充值
    public static String PAYMENTS_TYPE_DEPOSIT = "7";           // 提现
    /**
     * 支付方式
     */
    public static String RECEIPT_TYPE_UNIONPAY = "1";           // 银联
    public static String RECEIPT_TYPE_AlIPAY = "2";             // 支付宝
    public static String RECEIPT_TYPE_MICRO_CHANNEL_PAY = "3";  // 微信
    /**
     * 退款消息类别
     */
    public static String REFUND_MESSAGE_TYPE_FROM_USER = "1";   // 用户发给机构
    public static String REFUND_MESSAGE_TYPE_FROM_AGENT = "2";  // 机构发给用户
    /**
     * 红包使用状态（from client）
     */
    public static String REWARD_STATUS_CLIENT_USABLE = "1";     // 未使用
    public static String REWARD_STATUS_CLIENT_USED = "2";       // 已使用
    public static String REWARD_STATUS_CLIENT_OUTDATE = "3";    // 已过期
    /**
     * 红包使用状态
     */
    public static String REWARD_STATUS_USABLE = "0";            // 未使用
    public static String REWARD_STATUS_USED = "1";              // 已使用
    /**
     * 红包种别
     */
    public static String REWARD_STATUS_TYPE_CASH = "1";         // 未使用
    public static String REWARD_STATUS_TYPE_COUPON = "2";       // 已使用
    /**
     * 红包状态(用户)
     */
    public static String REWARD_STATUS_USER_NOT_GRABBING = "1"; // 未开抢
    public static String REWARD_STATUS_USER_GRABBING = "2";     // 已开抢
    public static String REWARD_STATUS_USER_GRABBED = "3";      // 已抢到
    public static String REWARD_STATUS_USER_FINISH = "4";       // 已抢完
}
