package com.xblazer.cms.model;

import com.xblazer.core.model.BaseModel;
import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.Table;

/**
 * Created by kevin on 15/12/21.
 */

@Table(name = "test")
public class Test extends BaseModel {

    public String key;

    @AssignID
    @AutoID
    public String getKey() {
        return key;
    }

    public void setKey(String value){
        key = value;
    }
}

