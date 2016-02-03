package com.xblazer.core;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.xblazer.core.common.DictKeys;
import com.xblazer.core.interceptor.AuthenticationInterceptor;
import com.xblazer.core.interceptor.RequestLoggerInterceptor;
import com.xblazer.core.plugin.ControllerPlugin;
import com.xblazer.utils.ToolString;
import org.beetl.core.GroupTemplate;
import org.beetl.ext.jfinal.BeetlRenderFactory;
import org.beetl.sql.ext.jfinal.JFinalBeetlSql;
import org.beetl.sql.ext.jfinal.Trans;
import org.slf4j.LoggerFactory;

/**
 * Jfinal API 引导式配置
 *
 * @author xblazer
 */
public class XblazerConfig extends JFinalConfig {

    /**
     * LOGGER
     */
    public static org.slf4j.Logger LOG  = LoggerFactory.getLogger(XblazerConfig.class);

    /**
     * 配置常量
     */
    @Override
    public void configConstant(Constants me) {

        LOG.info("configConstant 缓存 properties");
        PropKit.use("init.properties");

        LOG.info("configConstant 设置字符集");
        me.setEncoding(ToolString.encoding);

        LOG.info("configConstant 设置是否开发模式");
        me.setDevMode(PropKit.getBoolean(DictKeys.config_devMode));

        me.setMainRenderFactory(new BeetlRenderFactory());

        GroupTemplate gt = BeetlRenderFactory.groupTemplate;
        //根据gt可以添加扩展函数，格式化函数，共享变量等，

        LOG.info("configConstant 视图error page设置");
//        me.setError401View("/common/401.html");
//        me.setError403View("/common/403.html");
//        me.setError404View("/common/404.html");
//        me.setError500View("/common/500.html");
    }

    /**
     * 配置路由
     */
    @Override
    public void configRoute(Routes me) {
        LOG.info("configRoute 路由扫描注册");
        new ControllerPlugin(me).start();
    }

    /**
     * 配置插件
     */
    @Override
    public void configPlugin(Plugins me) {
        JFinalBeetlSql.init();

    }

    /**
     * 配置全局拦截器
     */
    @Override
    public void configInterceptor(Interceptors me) {
        // 请求认证
        LOG.info("configInterceptor 权限认证拦截器");
        me.add(new RequestLoggerInterceptor());
        me.add(new AuthenticationInterceptor());
        //me.addGlobalActionInterceptor(new Trans());

    }

    /**
     * 配置处理器
     */
    @Override
    public void configHandler(Handlers me) {

    }

    /**
     * 系统启动完成后执行
     */
    @Override
    public void afterJFinalStart() {

    }

    /**
     * 系统关闭前调用
     */
    @Override
    public void beforeJFinalStop() {
    }

    /**
     * TODO TEST MAIN
     *
     * @param args
     */
    public static void main(String[] args) {
        JFinal.start("WebRoot", 8080, "/", 5);
    }

}
