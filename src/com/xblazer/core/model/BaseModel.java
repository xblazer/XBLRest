package com.xblazer.core.model;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.ext.jfinal.JFinalBeetlSql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by kevin on 15/12/21.
 */
public class BaseModel<T> {

    /**
     * LOGGER
     */
    public static Logger LOG = LoggerFactory.getLogger(BaseModel.class);

    public SQLManager dao = JFinalBeetlSql.dao();

    public int update() {
        return dao.updateById(this);
    }

    public int delete(Object pk) {
        return dao.deleteById(this.getClass(), pk);
    }

    public int insert() {
        return dao.insert(this.getClass(), this);
    }

    public T findByPk(Object pk) {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        return dao.unique((Class<T>) params[0], pk);
    }

    public List<T> findAll() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        return dao.all((Class<T>) params[0]);
    }


}
