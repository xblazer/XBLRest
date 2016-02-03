package com.xblazer.core.service;

import com.xblazer.core.controller.BaseController;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.ext.jfinal.JFinalBeetlSql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kevin on 15/12/23.
 */
public class BaseService {

    /**
     * LOGGER
     */
    public static Logger LOG = LoggerFactory.getLogger(BaseController.class);

    public SQLManager dao = JFinalBeetlSql.dao();
}
