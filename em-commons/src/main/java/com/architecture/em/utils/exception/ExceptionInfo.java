package com.architecture.em.utils.exception;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by xujinxin on 2017/2/22.
 */
public class ExceptionInfo implements Serializable {
    private static final long serialVersionUID = 8140416340312871272L;


    private Integer errorCode;

    private String errorMsg;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {

        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {

        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
