package com.xblazer.core.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.xblazer.core.annotation.NotRequireLogin;
import com.xblazer.utils.ToolAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

/**
 * 权限认证拦截器
 */
public class AuthenticationInterceptor implements Interceptor {

    public static Logger LOG  = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    /**
     * 认证判断处理
     */
    @Override
    public void intercept(Invocation ai) {

        Controller ctl = (Controller) ai.getController();

        boolean notRequireLogin = ai.getMethod().isAnnotationPresent(
                NotRequireLogin.class);

        if (!notRequireLogin) {
            try {
                ToolAuth.auth(ctl.getRequest());
            } catch (Exception e) {

                // 认证失败，返回401
                LOG.error("Authentication failure.", e);

                ctl.getResponse().setStatus(
                        HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        // 认证通过，调用业务处理
        ai.invoke();
    }
}
