package com.xblazer.core.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by kevin on 15/12/21.
 */
public class RequestLoggerInterceptor implements Interceptor {

    /**
     * LOGGER
     */
    public static Logger LOG = LoggerFactory.getLogger(RequestLoggerInterceptor.class);

    private String[] HEADER_KEY = {
            "Accept-Charset",
            "Accept",
            "Accept-Encoding",
            "Authorization",
            "Host",
            "Referer",
            "x-forwarded-for",
            "Content-Length",
            "Cookie",
            "User-Agent",
            "Connection",
            "Allow",
            "Cache-Control",
            "Date",
            "Pragma",
            "Transfer-Encoding",
            "Upgrade"
    };

    @Override
    public void intercept(Invocation invocation) {
        Controller controller = invocation.getController();
        HttpServletRequest req = controller.getRequest();
        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator() + "===  request header start ===" + System.lineSeparator());
        for (String key : HEADER_KEY) {
            sb.append(StringUtils.rightPad(key, 20) + " : " + req.getHeader(key) + System.lineSeparator());
        }
        sb.append("===  request header end ===");
        LOG.debug(sb.toString());
        sb.delete(0, sb.length());

        Enumeration<String> atnames = controller.getAttrNames();
        if (atnames != null && atnames.hasMoreElements()) {
            sb.append(System.lineSeparator() + "===  request attribute start ===" + System.lineSeparator());
            do {
                String name = atnames.nextElement();
                sb.append(StringUtils.rightPad(name, 20) + " : " + controller.getAttr(name) + System.lineSeparator());
            } while (atnames.hasMoreElements());
            sb.append("===  request attribute end ===");
            LOG.debug(sb.toString());
            sb.delete(0, sb.length());
        }

        Enumeration<String> pnames = controller.getParaNames();
        if (pnames != null && pnames.hasMoreElements()) {
            sb.append(System.lineSeparator() + "===  request parameter start ===" + System.lineSeparator());
            do {
                String name = pnames.nextElement();
                sb.append(StringUtils.rightPad(name, 20) + " : " + controller.getPara(name) + System.lineSeparator());
            } while (pnames.hasMoreElements());
            sb.append("===  request parameter end ===");
            LOG.debug(sb.toString());
            sb.delete(0, sb.length());
        }

        invocation.invoke();
    }
}
