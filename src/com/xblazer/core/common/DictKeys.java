package com.xblazer.core.common;

import java.io.File;

/**
 * 常量数据字典
 *
 * @author NCIT
 */
public abstract class DictKeys {

    /**
     * auth key
     */
    public static final String auth_key = "auth.key";

    /**
     * api_key机构android
     */
    public static final String baidu_push_android_api_key_agent = "baidu.push.android.api_key.agent";

    /**
     * secret_key机构android
     */
    public static final String baidu_push_android_secret_key_agent = "baidu.push.android.secret_key.agent";

    /**
     * api_key机构ios
     */
    public static final String baidu_push_ios_api_key_agent = "baidu.push.ios.api_key.agent";

    /**
     * secret_key机构ios
     */
    public static final String baidu_push_ios_secret_key_agent = "baidu.push.ios.secret_key.agent";

    /**
     * 机构发布状态
     */
    public static final String baidu_push_ios_deploy_status_agent = "baidu.push.ios.deploy_status.agent";

    /**
     * api_key用户android
     */
    public static final String baidu_push_android_api_key_user = "baidu.push.android.api_key.user";

    /**
     * secret_key用户android
     */
    public static final String baidu_push_android_secret_key_user = "baidu.push.android.secret_key.user";

    /**
     * api_key用户ios
     */
    public static final String baidu_push_ios_api_key_user = "baidu.push.ios.api_key.user";

    /**
     * secret_key用户ios
     */
    public static final String baidu_push_ios_secret_key_user = "baidu.push.ios.secret_key.user";

    /**
     * 用户发布状态
     */
    public static final String baidu_push_ios_deploy_status_user = "baidu.push.ios.deploy_status.user";

    /**
     * api_key集团android
     */
    public static final String baidu_push_android_api_key_manager = "baidu.push.android.api_key.manager";

    /**
     * secret_key集团android
     */
    public static final String baidu_push_android_secret_key_manager = "baidu.push.android.secret_key.manager";

    /**
     * api_key集团ios
     */
    public static final String baidu_push_ios_api_key_manager = "baidu.push.ios.api_key.manager";

    /**
     * secret_key集团ios
     */
    public static final String baidu_push_ios_secret_key_manager = "baidu.push.ios.secret_key.manager";

    /**
     * 集团发布状态
     */
    public static final String baidu_push_ios_deploy_status_manager = "baidu.push.ios.deploy_status.manager";

    /**
     * 推送通知标题
     */
    public static final String notification_title = "notification.title";

    /**
     * 推送通知内容
     */
    public static final String notification_content = "notification.content";

    /**
     * URL缓存Key
     */
    public static final String cache_name_page = "SimplePageCachingFilter";

    /**
     * 系统缓存，主要是权限和数据字典等
     */
    public static final String cache_name_system = "system";

    /**
     * 开发模式
     */
    public static final String config_devMode = "config.devMode";

    /**
     * 加密
     */
    public static final String config_securityKey_key = "config.securityKey";

    /**
     * 密码最大错误次数
     */
    public static final String config_passErrorCount_key = "config.passErrorCount";

    /**
     * 密码错误最大次数后间隔登陆时间（小时）
     */
    public static final String config_passErrorHour_key = "config.passErrorHour";

    /**
     * #文件上传大小限制 10 * 1024 * 1024 = 10M
     */
    public static final String config_maxPostSize_key = "config.maxPostSize";

    /**
     * # cookie 值的时间
     */
    public static final String config_maxAge_key = "config.maxAge";

    /**
     * 当前数据库类型
     */
    public static final String db_type_key = "db.type";

    public static final String db_type_postgresql = "postgresql";
    public static final String db_type_mysql = "mysql";
    public static final String db_type_oracle = "oracle";

    public static final String db_connection_driverClass = "driverClass";
    public static final String db_connection_jdbcUrl = "jdbcUrl";
    public static final String db_connection_userName = "userName";
    public static final String db_connection_passWord = "passWord";

    public static final String db_connection_ip = "db_ip";
    public static final String db_connection_port = "db_port";
    public static final String db_connection_dbName = "db_name";

    public static final String db_initialSize = "db.initialSize";
    public static final String db_minIdle = "db.minIdle";
    public static final String db_maxActive = "db.maxActive";

    public static final String mongodb_database = "mongo.database";
    public static final String mongodb_host = "mongo.host";
    public static final String mongodb_port = "mongo.port";

    public static final String oo_sms_gateway = "oo.sms.gateway";
    public static final String oo_sms_key = "oo.sms.key";
    public static final String oo_sms_itemId = "oo.sms.itemId";
    public static final String oo_sms_contentSign = "oo.sms.contentSign";

    /**
     * 分页参数初始化值
     */
    public static final int default_pageNumber = 1;// 第几页
    public static final int default_pageSize = 20;// 每页显示几多

    /**
     * 用户登录状态码
     */
    public static final int login_info_0 = 0;// 用户不存在
    public static final int login_info_1 = 1;// 停用账户
    public static final int login_info_2 = 2;// 密码错误次数超限
    public static final int login_info_3 = 3;// 密码验证成功
    public static final int login_info_4 = 4;// 密码验证失败

    /**
     * 图片上传的根路径
     */
    public static final String path_image_root = new File(DictKeys.class.getClassLoader().getResource("/").getPath())
            .getParentFile().getParent();
    public static final String path_image_user = "www.images.user";
    public static final String path_image_store = "www.images.store";
    public static final String path_image_medicine = "www.images.medicine";
    public static final String path_image_courier = "www.images.courier";
    public static final String path_lucene_index = "res.index.indexPath";
    public static final String path_lenovo_index = "res.index.lenovo.indexPath";
    /**
     * Redis配置文件
     */
    public static final String REDIS_CONFIG_PATH = "redis.properties";
    /**
     * 微信支付设定
     */
    public static final String WXPAY_APPID = "weixin.appid";
    public static final String WXPAY_MCHID = "weixin.mchid";
    public static final String WXPAY_APIKEY = "weixin.apikey";
    public static final String WXPAY_UNIFIEDORDERURL = "weixin.unifiedorderurl";
    public static final String WXPAY_NOTIFYURL = "weixin.notifyurl";
    /**
     * 支付宝设定
     */
    public static final String ALIPAY_PAYMENT_TYPE = "alipay.private_key";
    public static final String ALIPAY_NOTIFY_URL = "alipay.notify_url";
    public static final String ALIPAY_PARTNER = "alipay.partner";
    public static final String ALIPAY_SELLER_EMAIL = "alipay.seller_email";
    /**
     * 加盟店和一般商家的利润提成
     */
    public static final String PROFIT_JOIN_IN_BUSINESS = "profit.join_in_business_key";
    public static final String PROFIT_GENERAL_BUSINESS = "profit.general_business_key";
    /**
     * 药店照片尺寸
     */
    public static String drugstore_image_size_w = "www.images.store.size.w";
    public static String drugstore_image_size_h = "www.images.store.size.h";
    /**
     * 图片尺寸：小
     */
    public static String image_size_s_w = "www.images.size.s.w";
    public static String image_size_s_h = "www.images.size.s.h";
    /**
     * 图片尺寸：中
     */
    public static String image_size_m_w = "www.images.size.m.w";
    public static String image_size_m_h = "www.images.size.m.h";
    /**
     * 图片尺寸：大
     */
    public static String image_size_l_w = "www.images.size.l.w";
    public static String image_size_l_h = "www.images.size.l.h";
    /**
     * QRCode设定
     */
    public static String qrcode_width = "qrcode.width";
    public static String qrcode_height = "qrcode.height";
    public static String qrcode_format = "qrcode.format";
    public static String qrcode_margin = "qrcode.margin";
    public static String qrcode_error_correction_level = "qrcode.errorCorrectionLevel";
}
