package com.xblazer.core.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by kevin on 15/12/21.
 */
public class BaseController extends Controller {

    /**
     * LOGGER
     */
    public static Logger LOG = LoggerFactory.getLogger(BaseController.class);

    /**
     *
     * @param list
     * @param count
     * @return
     */
    public Page getPage(List list, int count) {
        int pageNumber = getParaToInt(0, 1);
        int totalPage = count / 10 + count % 10 != 0 ? 1 : 0;
        Page page = new Page(list, pageNumber, 10, totalPage, count);
        return page;
    }
}
