package com.xblazer.cms.controller;

import com.jfinal.aop.Before;
import com.jfinal.ext.interceptor.Restful;
import com.jfinal.plugin.activerecord.Page;
import com.xblazer.cms.model.Test;
import com.xblazer.core.annotation.ControllerConfig;
import com.xblazer.core.annotation.NotRequireLogin;
import com.xblazer.core.controller.BaseController;
import com.xblazer.core.service.BaseService;
import org.beetl.sql.ext.jfinal.Trans;

import java.util.List;

/**
 * IndexController
 */

@ControllerConfig(key = {"/api/test"})
public class IndexController extends BaseController {

    BaseService service = new BaseService();

    @NotRequireLogin
    @Before(Restful.class)
    public void index() {
        //test.dao.select("", null, null);
//        List<Test> list = service.dao.all(Test.class, getParaToInt(0, 1), 10);
//        int count = service.dao.allCount(Test.class);
//        Page page = getPage(list, count);
        renderJson("test");
    }

    @Before(Trans.class)
    public void save() {
        Test test = getModel(Test.class);
        if (test.getKey() != null) {
            test.update();
        } else {
            test.setKey("002");
            test.insert();
        }

    }

    @Before(Trans.class)
    public void delete() {
        String key = getPara("key");
        service.dao.deleteById(Test.class, key);
    }

    public void update(){

    }

    @NotRequireLogin
    public void show(){
        renderJson(getPara());
    }

}





