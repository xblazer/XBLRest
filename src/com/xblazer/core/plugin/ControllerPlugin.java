package com.xblazer.core.plugin;

import com.jfinal.config.Routes;
import com.jfinal.core.Controller;
import com.jfinal.plugin.IPlugin;
import com.xblazer.core.annotation.ControllerConfig;
import com.xblazer.utils.ToolClassSearcher;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 扫描Controller上的注解，绑定Controller和controllerKey
 *
 * @author NCIT
 */
public class ControllerPlugin implements IPlugin {

    public static org.slf4j.Logger LOG = LoggerFactory.getLogger(ControllerPlugin.class);

    private Routes me;

    public ControllerPlugin(Routes me) {
        this.me = me;
    }

    @Override
    public boolean start() {
        // 查询所有继承BaseController的类
        List<Class<? extends Controller>> controllerClasses = ToolClassSearcher.of(Controller.class).search();
        // 可以指定查找jar包，jar名称固定，避免扫描所有文件
        // 循环处理自动注册映射
        for (Class controller : controllerClasses) {
            // 获取注解对象
            ControllerConfig controllerBind = (ControllerConfig) controller.getAnnotation(ControllerConfig.class);
            if (controllerBind == null) {
                LOG.debug(controller.getName() + "继承了BaseController，但是没有注解绑定映射路径");
                continue;
            }

            // 获取映射路径数组
            String[] controllerKeys = controllerBind.key();
            for (String controllerKey : controllerKeys) {
                controllerKey = controllerKey.trim();
                if (controllerKey.equals("")) {
                    LOG.error(controller.getName() + "注解错误，映射路径为空");
                    continue;
                }
                // 注册映射
                me.add(controllerKey, controller);
            }
        }
        return true;
    }

    @Override
    public boolean stop() {
        return true;
    }

}
